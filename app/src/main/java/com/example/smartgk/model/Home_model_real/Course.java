package com.example.smartgk.model.Home_model_real;

public class Course {
    private String seo_keyword;

    private String level;

    private String description;

    private String created_at;

    private String categorie_id;

    private String seo_title;

    private String package_price;

    private String level_name;

    private String updated_at;

    private String seo_description;

    private String id;

    private String slug;

    private String status;

    private String image;


    public String getSeo_keyword ()
    {
        return seo_keyword;
    }

    public void setSeo_keyword (String seo_keyword)
    {
        this.seo_keyword = seo_keyword;
    }

    public String getLevel ()
    {
        return level;
    }

    public void setLevel (String level)
    {
        this.level = level;
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

    public String getCategorie_id ()
    {
        return categorie_id;
    }

    public void setCategorie_id (String categorie_id)
    {
        this.categorie_id = categorie_id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [seo_keyword = "+seo_keyword+", level = "+level+", description = "+description+", created_at = "+created_at+", categorie_id = "+categorie_id+", seo_title = "+seo_title+", package_price = "+package_price+", level_name = "+level_name+", updated_at = "+updated_at+", seo_description = "+seo_description+", id = "+id+", slug = "+slug+", status = "+status+"]";
    }
}
