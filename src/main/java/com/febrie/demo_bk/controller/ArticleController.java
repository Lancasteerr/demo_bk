package com.febrie.demo_bk.controller;

import com.febrie.demo_bk.pojo.BlogArticle;
import com.febrie.demo_bk.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired
    private BlogArticleService blogArticleService;

    @CrossOrigin

    @GetMapping("api/get_article_list")
    public Page<BlogArticle> getArticles(@RequestParam int page,@RequestParam int size){
        return blogArticleService.getArticleList(page - 1,size);
    }

    @CrossOrigin

    @GetMapping("api/article")
    public BlogArticle getArticleById(@RequestParam int id){
        return blogArticleService.findById(id);
    }
}
