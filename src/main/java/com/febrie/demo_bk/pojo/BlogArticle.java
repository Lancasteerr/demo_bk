package com.febrie.demo_bk.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.febrie.demo_bk.dto.ArticleDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "jotter_article")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class BlogArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String articleTitle;

    private String articleContentHtml;

    private String articleContentMd;

    private String articleAbstract;

    private LocalDateTime articleDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(LocalDateTime articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getArticleContentMd() {
        return articleContentMd;
    }

    public void setArticleContentMd(String articleContentMd) {
        this.articleContentMd = articleContentMd;
    }

    public String getArticleContentHtml() {
        return articleContentHtml;
    }

    public void setArticleContentHtml(String articleContentHtml) {
        this.articleContentHtml = articleContentHtml;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Override
    public String toString() {
        return "BlogArticle{" +
                "id=" + id +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContentHtml='" + articleContentHtml + '\'' +
                ", articleContentMd='" + articleContentMd + '\'' +
                ", articleAbstract='" + articleAbstract + '\'' +
                ", articleDate=" + articleDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BlogArticle that = (BlogArticle) o;
        return id == that.id && Objects.equals(articleTitle, that.articleTitle) && Objects.equals(articleContentHtml, that.articleContentHtml) && Objects.equals(articleContentMd, that.articleContentMd) && Objects.equals(articleAbstract, that.articleAbstract) && Objects.equals(articleDate, that.articleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articleTitle, articleContentHtml, articleContentMd, articleAbstract, articleDate);
    }

    public static ArticleDTO toDTO(BlogArticle blogArticle){
        if(blogArticle==null) return null;

        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setId(blogArticle.getId());
        articleDTO.setArticleAbstract(blogArticle.getArticleAbstract());
        articleDTO.setArticleContentHtml(blogArticle.getArticleContentHtml());
        articleDTO.setArticleContentMd(blogArticle.getArticleContentMd());
        articleDTO.setArticleTitle(blogArticle.getArticleTitle());
        articleDTO.setArticleDate(blogArticle.getArticleDate());
        return articleDTO;
    }

    public static BlogArticle toPojo(ArticleDTO articleDTO){
        if(articleDTO == null) return null;

        BlogArticle blogArticle = new BlogArticle();

        blogArticle.setArticleDate(articleDTO.getArticleDate());
        blogArticle.setArticleAbstract(articleDTO.getArticleAbstract());
        blogArticle.setId(articleDTO.getId());
        blogArticle.setArticleTitle(articleDTO.getArticleTitle());
        blogArticle.setArticleContentMd(articleDTO.getArticleContentMd());
        blogArticle.setArticleContentHtml(articleDTO.getArticleContentHtml());
        return blogArticle;
    }

}
