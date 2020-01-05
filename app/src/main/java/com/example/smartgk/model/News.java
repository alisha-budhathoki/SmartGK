package com.example.smartgk.model;

public class News {

    int newsImg;
    String newsDate, newsDesc, newsTitle;

    public News() {
        this.newsImg = newsImg;
        this.newsDate = newsDate;
        this.newsDesc = newsDesc;
        this.newsTitle = newsTitle;
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

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
}
