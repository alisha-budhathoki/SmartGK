package com.example.smartgk.model;

import java.util.ArrayList;

public class NewsModel
{
    public ArrayList<Results> results = new ArrayList<>();
    public class Results {
        String id, name, slug, image, alt_image, description, seo_title, seo_keyword, seo_description, date, status, created_at, updated_at;

        public Results(String id, String name, String slug, String image, String alt_image, String description, String seo_title, String seo_keyword, String seo_description, String date, String status, String created_at, String updated_at) {
            this.id = id;
            this.name = name;
            this.slug = slug;
            this.image = image;
            this.alt_image = alt_image;
            this.description = description;
            this.seo_title = seo_title;
            this.seo_keyword = seo_keyword;
            this.seo_description = seo_description;
            this.date = date;
            this.status = status;
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

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getAlt_image() {
            return alt_image;
        }

        public void setAlt_image(String alt_image) {
            this.alt_image = alt_image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSeo_title() {
            return seo_title;
        }

        public void setSeo_title(String seo_title) {
            this.seo_title = seo_title;
        }

        public String getSeo_keyword() {
            return seo_keyword;
        }

        public void setSeo_keyword(String seo_keyword) {
            this.seo_keyword = seo_keyword;
        }

        public String getSeo_description() {
            return seo_description;
        }

        public void setSeo_description(String seo_description) {
            this.seo_description = seo_description;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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
    }
