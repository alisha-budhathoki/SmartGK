package com.example.smartgk.model.user_model;

public class GetPaper
{
    private String level, id, paper_name, slug, post_id, description, image, status, popular, price, seo_title, seo_description, seo_keyword, created_at, updated_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaper_name() {
        return paper_name;
    }

    public void setPaper_name(String paper_name) {
        this.paper_name = paper_name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPopular() {
        return popular;
    }

    public void setPopular(String popular) {
        this.popular = popular;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeo_title() {
        return seo_title;
    }

    public void setSeo_title(String seo_title) {
        this.seo_title = seo_title;
    }

    public String getSeo_description() {
        return seo_description;
    }

    public void setSeo_description(String seo_description) {
        this.seo_description = seo_description;
    }

    public String getSeo_keyword() {
        return seo_keyword;
    }

    public void setSeo_keyword(String seo_keyword) {
        this.seo_keyword = seo_keyword;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getLevel ()
    {
        return level;
    }

    public void setLevel (String level)
    {
        this.level = level;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [level = "+level+",id = "+id+", paper_name= "+paper_name+",slug = "+slug+",post_id="+post_id+",description="+description+",image = "+image+", status = "+status+",popular = "+popular+", price = "+price+",seo_title = "+seo_title+", seo_description = "+seo_description+",seo_keyword = "+seo_keyword+", created_at = "+created_at+" ]";
    }
}
