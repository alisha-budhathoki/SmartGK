package com.example.smartgk.model.Home_Model;

public class Course_one {
    private String seo_keyword;

    private String level_name;

    private String updated_at;

    private String seo_description;

    private String description;

    private String created_at;

    private String id;

    private String categorie_id;

    private String slug;

    private String seo_title;

    private String package_price;

    private String status;

    public String getSeo_keyword ()
    {
        return seo_keyword;
    }

    public void setSeo_keyword (String seo_keyword)
    {
        this.seo_keyword = seo_keyword;
    }

    public String getLevel_name ()
    {
        return level_name;
    }

    public void setLevel_name (String level_name)
    {
        this.level_name = level_name;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getSeo_description ()
    {
        return seo_description;
    }

    public void setSeo_description (String seo_description)
    {
        this.seo_description = seo_description;
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

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getCategorie_id ()
    {
        return categorie_id;
    }

    public void setCategorie_id (String categorie_id)
    {
        this.categorie_id = categorie_id;
    }

    public String getSlug ()
    {
        return slug;
    }

    public void setSlug (String slug)
    {
        this.slug = slug;
    }

    public String getSeo_title ()
    {
        return seo_title;
    }

    public void setSeo_title (String seo_title)
    {
        this.seo_title = seo_title;
    }

    public String getPackage_price ()
    {
        return package_price;
    }

    public void setPackage_price (String package_price)
    {
        this.package_price = package_price;
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
        return "ClassPojo [seo_keyword = "+seo_keyword+", level_name = "+level_name+", updated_at = "+updated_at+", seo_description = "+seo_description+", description = "+description+", created_at = "+created_at+", id = "+id+", categorie_id = "+categorie_id+", slug = "+slug+", seo_title = "+seo_title+", package_price = "+package_price+", status = "+status+"]";
    }
}
