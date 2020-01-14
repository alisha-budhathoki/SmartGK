package com.example.smartgk.model.Home_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeModel {
    @SerializedName("course_two")
    @Expose
    private List<Course_two> course_two;

    @SerializedName("book")
    @Expose
    private List<Book> book;

    @SerializedName("course_three")
    @Expose
    private List<Course_three> course_three;

    @SerializedName("carousel")
    @Expose
    private List<Carousel> carousel;

    @SerializedName("course_one")
    @Expose
    private List<Course_one> course_one;


    public List<Course_two> getCourse_two ()
    {
        return course_two;
    }

    public void setCourse_two (List<Course_two> course_two)
    {
        this.course_two = course_two;
    }

    public List<Book> getBook ()
    {
        return book;
    }

    public void setBook (List<Book> book)
    {
        this.book = book;
    }

    public List<Course_three> getCourse_three ()
    {
        return course_three;
    }

    public void setCourse_three (List<Course_three> course_three)
    {
        this.course_three = course_three;
    }

    public List<Carousel> getCarousel ()
    {
        return carousel;
    }

    public void setCarousel (List<Carousel> carousel)
    {
        this.carousel = carousel;
    }

    public List<Course_one> getCourse_one ()
    {
        return course_one;
    }

    public void setCourse_one (List<Course_one> course_one)
    {
        this.course_one = course_one;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [course_two = "+course_two+", book = "+book+", course_three = "+course_three+", carousel = "+carousel+", course_one = "+course_one+"]";
    }
}
