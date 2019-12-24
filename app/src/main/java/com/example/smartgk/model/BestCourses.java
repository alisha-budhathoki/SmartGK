package com.example.smartgk.model;

public class BestCourses {
    int image;
    String courseName, coursePrice;

    public BestCourses() {
        this.image = image;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }
}
