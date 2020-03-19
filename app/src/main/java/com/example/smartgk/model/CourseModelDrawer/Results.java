package com.example.smartgk.model.CourseModelDrawer;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results
{
    @SerializedName("course")
    @Expose
    public List<Course> course;

    public List<Course> getCourse ()
    {
        return course;
    }

    public void setCourse (List<Course> course)
    {
        this.course = course;
    }


    @Override
    public String toString()
    {
        return "ClassPojo [course = "+course+"]";
    }
}