package com.example.smartgk.model.Home_model_real;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results
{
    @SerializedName("book")
    @Expose
    private List<Book> book;

    @SerializedName("course")
    @Expose
    private List<Course> course;

    @SerializedName("carousel")
    @Expose
    private List<Carousel> carousel;

    public List<Book> getBook ()
    {
        return book;
    }

    public void setBook (List<Book> book)
    {
        this.book = book;
    }

    public List<Course> getCourse ()
    {
        return course;
    }

    public void setCourse (List<Course> course)
    {
        this.course = course;
    }

    public List<Carousel> getCarousel ()
    {
        return carousel;
    }

    public void setCarousel (List<Carousel> carousel)
    {
        this.carousel = carousel;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [book = "+book+", course = "+course+", carousel = "+carousel+"]";
    }
}