package com.febrie.demo_bk.dao;

import com.febrie.demo_bk.pojo.BlogArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogArticleDAO extends JpaRepository<BlogArticle,Integer> {
    BlogArticle findById (int id);

    Page<BlogArticle> findAll(Pageable pageable);
}
