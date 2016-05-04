package com.xuan.smzdm.beans;

import org.nutz.ioc.loader.annotation.IocBean;

import java.io.Serializable;

/**
 * Created by bj on 2016/5/2.
 */
@IocBean(name = "goods", singleton = false)
public class Goods implements Serializable{
    private String title;
    private String href;

    private String articleUrl;
    private String articleTitle;
    private String timesort;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getTimesort() {
        return timesort;
    }

    public void setTimesort(String timesort) {
        this.timesort = timesort;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "title='" + title + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
