package com.example.smartgk.model.Home_model_real;

public class Carousel {
    private String file;

    private String alt_image;

    private String updated_at;

    private String created_at;

    private String id;

    private String status;

    public String getFile ()
    {
        return file;
    }

    public void setFile (String file)
    {
        this.file = file;
    }

    public String getAlt_image ()
    {
        return alt_image;
    }

    public void setAlt_image (String alt_image)
    {
        this.alt_image = alt_image;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
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
        return "ClassPojo [file = "+file+", alt_image = "+alt_image+", updated_at = "+updated_at+", created_at = "+created_at+", id = "+id+", status = "+status+"]";
    }
}
