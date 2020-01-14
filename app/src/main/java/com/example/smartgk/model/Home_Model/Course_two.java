package com.example.smartgk.model.Home_Model;

public class Course_two {
    private String image;

    private String seo_keyword;

    private String level_id;

    private String description;

    private String created_at;

    private String package_price;

    private String seo_title;

    private String updated_at;

    private String post_name;

    private String seo_description;

    private String id;

    private String slug;

    private String status;

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getSeo_keyword ()
    {
        return seo_keyword;
    }

    public void setSeo_keyword (String seo_keyword)
    {
        this.seo_keyword = seo_keyword;
    }

    public String getLevel_id ()
    {
        return level_id;
    }

    public void setLevel_id (String level_id)
    {
        this.level_id = level_id;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getPackage_price ()
    {
        return package_price;
    }

    public void setPackage_price (String package_price)
    {
        this.package_price = package_price;
    }

    public String getSeo_title ()
    {
        return seo_title;
    }

    public void setSeo_title (String seo_title)
    {
        this.seo_title = seo_title;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getPost_name ()
    {
        return post_name;
    }

    public void setPost_name (String post_name)
    {
        this.post_name = post_name;
    }

    public String getSeo_description ()
    {
        return seo_description;
    }

    public void setSeo_description (String seo_description)
    {
        this.seo_description = seo_description;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getSlug ()
    {
        return slug;
    }

    public void setSlug (String slug)
    {
        this.slug = slug;
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
        return "ClassPojo [image = "+image+", seo_keyword = "+seo_keyword+", level_id = "+level_id+", description = "+description+", created_at = "+created_at+", package_price = "+package_price+", seo_title = "+seo_title+", updated_at = "+updated_at+", post_name = "+post_name+", seo_description = "+seo_description+", id = "+id+", slug = "+slug+", status = "+status+"]";
    }
}
