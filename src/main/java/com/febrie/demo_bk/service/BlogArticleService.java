package com.febrie.demo_bk.service;

import com.febrie.demo_bk.dao.BlogArticleDAO;
import com.febrie.demo_bk.dto.ArticleDTO;
import com.febrie.demo_bk.pojo.BlogArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BlogArticleService {
    @Autowired
    private BlogArticleDAO blogArticleDAO;
    @Autowired
    private RedisService redisService;

    /**
     * 先改数据库，再删Redis
     */
    public void addOrUpdate(ArticleDTO articleDTO) {
        blogArticleDAO.save(BlogArticle.toPojo(articleDTO));
        redisService.delete("blog:article:detail:"+articleDTO.getId());
    }

    /**
     * 无缓存则查库后写入缓存，注意此处空对象不写入redis，直接返回null
     */
    public ArticleDTO findById (int id) {

        String key = "blog:article:detail:" + id;

        ArticleDTO cache = redisService.getObject(key,ArticleDTO.class);
        if(cache==null){
            ArticleDTO dto = BlogArticle.toDTO(blogArticleDAO.findById(id));
            if(dto==null) return null;
            redisService.setObject(key,dto,30, TimeUnit.DAYS);
            return dto;
        }

        return cache;
    }

    public void delete(int id) {
        blogArticleDAO.deleteById(id);
        redisService.delete("blog:article:detail:" + id);
    }

    public Page<BlogArticle> getArticleList(int page,int size) {
        Pageable pageable = PageRequest.of(page,size);
        return blogArticleDAO.findAll(pageable);
    }
}
