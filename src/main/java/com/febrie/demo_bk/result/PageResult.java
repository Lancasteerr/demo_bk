package com.febrie.demo_bk.result;

import com.febrie.demo_bk.pojo.BlogArticle;
import org.springframework.data.domain.Page;

import java.util.List;

public class PageResult {
    private List<BlogArticle> content;

    private long totalElements;

    private int number;

    /**
     * 必须有无参构造，Jackson反序列化时会有类似语句：PageResult = new PageResult();
     */
    public PageResult(){}

    public PageResult(List<BlogArticle> content, long totalElements, int number) {
        this.content = content;
        this.totalElements = totalElements;
        this.number = number;
    }

    public static PageResult from(Page<BlogArticle> BlogArticleS){
        return new PageResult(BlogArticleS.getContent(),BlogArticleS.getTotalElements(), BlogArticleS.getNumber());
    }

    //getter & setter
    public List<BlogArticle> getContent() {
        return content;
    }

    public void setContent(List<BlogArticle> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
