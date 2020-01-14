package com.example.smartgk.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity()
public class BookData {

    @PrimaryKey
    public int id;
    public final String title;
    public final String description;
    public final String author;
    public final String alt_image;
    public final String publisher;
    public final String price;
    public final String pages;
    public final String status;
    public final String image;
    public final String created_at;
    public final String updated_at;

    @Ignore
    public BookData(@NonNull int id, String title, String description, String author, String alt_image, String publisher, String price, String pages, String status, String image, String created_at, String updated_at) {
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

    public BookData(String title, String description, String author, String alt_image, String publisher, String price, String pages, String status, String image, String created_at, String updated_at) {
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

    @NonNull

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getAlt_image() {
        return alt_image;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPrice() {
        return price;
    }

    public String getPages() {
        return pages;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
