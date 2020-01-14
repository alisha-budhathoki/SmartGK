package com.example.smartgk.model.user_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results
{
    @SerializedName("getPaper")
    @Expose
    private List<GetPaper> getPaper;

    @SerializedName("user")
    @Expose
    private User user;

    public List<GetPaper> getGetPaper ()
    {
        return getPaper;
    }

    public void setGetPaper (List<GetPaper> getPaper)
    {
        this.getPaper = getPaper;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [getPaper = "+getPaper+", user = "+user+"]";
    }
}
