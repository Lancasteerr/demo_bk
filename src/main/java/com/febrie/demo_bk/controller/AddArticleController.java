package com.febrie.demo_bk.controller;

import com.febrie.demo_bk.pojo.BlogArticle;
import com.febrie.demo_bk.result.Result;
import com.febrie.demo_bk.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class AddArticleController {
    @Autowired
    BlogArticleService blogArticleService;

    @CrossOrigin
    @PostMapping(value = "api/admin/content/article")
    @ResponseBody
    public Result article(@RequestBody BlogArticle blogArticle) {
        blogArticle.setArticleDate(LocalDateTime.now());
        blogArticleService.addOrUpdate(blogArticle);
        return new Result(200);
    }
}
