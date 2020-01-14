package com.example.smartgk.model.user_model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModelClass
{
    private String response_time;

    @SerializedName("results")
    @Expose
    private Results results;

    private String status;

    public String getResponse_time ()
    {
        return response_time;
    }

    public void setResponse_time (String response_time)
    {
        this.response_time = response_time;
    }

    public Results getResults ()
    {
        return results;
    }

    public void setResults (Results results)
    {
        this.results = results;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [response_time = "+response_time+", results = "+results+", status = "+status+"]";
    }
}
