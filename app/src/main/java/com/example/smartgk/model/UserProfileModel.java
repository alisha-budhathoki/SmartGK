package com.example.smartgk.model;

import java.util.ArrayList;

public class UserProfileModel {

    public ArrayList<UserProfileModel.Results> results = new ArrayList<>();
    public class Results{
        public ArrayList<User> user = new ArrayList<>();
        public ArrayList<GetPaper> getPaper = new ArrayList<>();

        public Results(ArrayList<User> user, ArrayList<GetPaper> getPaper) {
            this.user = user;
            this.getPaper = getPaper;
        }

        public ArrayList<User> getUser() {
            return user;
        }

        public void setUser(ArrayList<User> user) {
            this.user = user;
        }

        public ArrayList<GetPaper> getGetPaper() {
            return getPaper;
        }

        public void setGetPaper(ArrayList<GetPaper> getPaper) {
            this.getPaper = getPaper;
        }
    }

    private class User {
        public String id, name, image, bio, DOB, address, email, phone_no, slug, validation, banned_status, status, unique_id, created_at, updated_at;

        public User(String id, String name, String image, String bio, String DOB, String address, String email, String phone_no, String slug, String validation, String banned_status, String status, String unique_id, String created_at, String updated_at) {
            this.id = id;
            this.name = name;
            this.image = image;
            this.bio = bio;
            this.DOB = DOB;
            this.address = address;
            this.email = email;
            this.phone_no = phone_no;
            this.slug = slug;
            this.validation = validation;
            this.banned_status = banned_status;
            this.status = status;
            this.unique_id = unique_id;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getDOB() {
            return DOB;
        }

        public void setDOB(String DOB) {
            this.DOB = DOB;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone_no() {
            return phone_no;
        }

        public void setPhone_no(String phone_no) {
            this.phone_no = phone_no;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getValidation() {
            return validation;
        }

        public void setValidation(String validation) {
            this.validation = validation;
        }

        public String getBanned_status() {
            return banned_status;
        }

        public void setBanned_status(String banned_status) {
            this.banned_status = banned_status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUnique_id() {
            return unique_id;
        }

        public void setUnique_id(String unique_id) {
            this.unique_id = unique_id;
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
    }

    private class GetPaper {
        String id, paper_name, slug, post_id, description, image, status, popular, price, seo_title, seo_description, seo_keyword, created_at, updated_at, level;

        public GetPaper(String id, String paper_name, String slug, String post_id, String description, String image, String status, String popular, String price, String seo_title, String seo_description, String seo_keyword, String created_at, String updated_at, String level) {
            this.id = id;
            this.paper_name = paper_name;
            this.slug = slug;
            this.post_id = post_id;
            this.description = description;
            this.image = image;
            this.status = status;
            this.popular = popular;
            this.price = price;
            this.seo_title = seo_title;
            this.seo_description = seo_description;
            this.seo_keyword = seo_keyword;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.level = level;
        }

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

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }
}
