package com.example.smartgk.model;

public class Reviews {

    int reviewerImg;
    String reviewerName, reviewDate, reviewDesc;

    public Reviews() {
        this.reviewerImg = reviewerImg;
        this.reviewerName = reviewerName;
        this.reviewDate = reviewDate;
        this.reviewDesc = reviewDesc;
    }

    public int getReviewerImg() {
        return reviewerImg;
    }

    public void setReviewerImg(int reviewerImg) {
        this.reviewerImg = reviewerImg;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }
}
