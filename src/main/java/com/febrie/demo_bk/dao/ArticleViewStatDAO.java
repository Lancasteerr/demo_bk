package com.febrie.demo_bk.dao;

import com.febrie.demo_bk.pojo.ArticleViewStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleViewStatDAO extends JpaRepository<ArticleViewStat, Integer> {
    //更新文章浏览量
    @Modifying
    @Transactional
    @Query("UPDATE ArticleViewStat a SET a.pv = a.pv + :pvCount WHERE a.articleId = :articleId")
    void updateViewCount(int articleId,String statDate,int pvCount);

    int getViewCountByArticleId(int articleId);
}
