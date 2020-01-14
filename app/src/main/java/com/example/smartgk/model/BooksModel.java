package com.example.smartgk.model;

import java.util.ArrayList;

public class BooksModel {
    public ArrayList<Results> results = new ArrayList<>();

    public class Results {

        String id, title, description, author, alt_image, publisher, price, pages, status, image, created_at, updated_at;

        public Results(String id, String title, String description, String author, String alt_image, String publisher, String price, String pages, String status, String image, String created_at, String updated_at) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.author = author;
            this.alt_image = alt_image;
            this.publisher = publisher;
            this.price = price;
            this.pages = pages;
            this.status = status;
            this.image = image;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAlt_image() {
            return alt_image;
        }

        public void setAlt_image(String alt_image) {
            this.alt_image = alt_image;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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
