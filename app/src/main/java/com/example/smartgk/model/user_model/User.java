package com.example.smartgk.model.user_model;


public class User
{
    private String image;

    private String phone_no;

    private String address;

    private String unique_id;

    private String bio;

    private String created_at;

    private String banned_status;

    private String updated_at;

    private String DOB;

    private String name;

    private String id;

    private String email;

    private String slug;

    private String validation;

    private String status;

    public String getImage ()
{
    return image;
}

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getPhone_no ()
    {
        return phone_no;
    }

    public void setPhone_no (String phone_no)
    {
        this.phone_no = phone_no;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getUnique_id ()
    {
        return unique_id;
    }

    public void setUnique_id (String unique_id)
    {
        this.unique_id = unique_id;
    }

    public String getBio ()
{
    return bio;
}

    public void setBio (String bio)
    {
        this.bio = bio;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getBanned_status ()
    {
        return banned_status;
    }

    public void setBanned_status (String banned_status)
    {
        this.banned_status = banned_status;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getDOB ()
{
    return DOB;
}

    public void setDOB (String DOB)
    {
        this.DOB = DOB;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getSlug ()
    {
        return slug;
    }

    public void setSlug (String slug)
    {
        this.slug = slug;
    }

    public String getValidation ()
    {
        return validation;
    }

    public void setValidation (String validation)
    {
        this.validation = validation;
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
        return "ClassPojo [image = "+image+", phone_no = "+phone_no+", address = "+address+", unique_id = "+unique_id+", bio = "+bio+", created_at = "+created_at+", banned_status = "+banned_status+", updated_at = "+updated_at+", DOB = "+DOB+", name = "+name+", id = "+id+", email = "+email+", slug = "+slug+", validation = "+validation+", status = "+status+"]";
    }
}
