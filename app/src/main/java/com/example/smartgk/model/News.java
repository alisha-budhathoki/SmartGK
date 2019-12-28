package com.example.smartgk.model;

public class News {

    int newsImg;
    String newsDate, newsDesc;

    public News() {
        this.newsImg = newsImg;
        this.newsDate = newsDate;
        this.newsDesc = newsDesc;
    }

    public int getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(int newsImg) {
        this.newsImg = newsImg;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsDesc() {
        return newsDesc;
    }

    public void setNewsDesc(String newsDesc) {
        this.newsDesc = newsDesc;
    }
}
