package com.example.smartgk.model.Home_Model;

public class Book {
    private String image;

    private String alt_image;

    private String pages;

    private String updated_at;

    private String author;

    private String price;

    private String description;

    private String publisher;

    private String created_at;

    private String id;

    private String title;

    private String status;

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getAlt_image ()
    {
        return alt_image;
    }

    public void setAlt_image (String alt_image)
    {
        this.alt_image = alt_image;
    }

    public String getPages ()
    {
        return pages;
    }

    public void setPages (String pages)
    {
        this.pages = pages;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getPublisher ()
    {
        return publisher;
    }

    public void setPublisher (String publisher)
    {
        this.publisher = publisher;
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

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
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
        return "ClassPojo [image = "+image+", alt_image = "+alt_image+", pages = "+pages+", updated_at = "+updated_at+", author = "+author+", price = "+price+", description = "+description+", publisher = "+publisher+", created_at = "+created_at+", id = "+id+", title = "+title+", status = "+status+"]";
    }
}
