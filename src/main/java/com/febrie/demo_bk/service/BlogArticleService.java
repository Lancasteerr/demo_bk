package com.febrie.demo_bk.service;

import com.febrie.demo_bk.dao.BlogArticleDAO;
import com.febrie.demo_bk.pojo.BlogArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogArticleService {
    @Autowired
    private BlogArticleDAO blogArticleDAO;

    public void addOrUpdate(BlogArticle blogArticle) {
        blogArticleDAO.save(blogArticle);
    }

    public BlogArticle findById (int id) {
        return blogArticleDAO.findById(id);
    }

    public void delete(int id) {
        blogArticleDAO.deleteById(id);
    }

    public Page<BlogArticle> getArticleList(int page,int size) {
        Pageable pageable = PageRequest.of(page,size);
        return blogArticleDAO.findAll(pageable);
    }
}
