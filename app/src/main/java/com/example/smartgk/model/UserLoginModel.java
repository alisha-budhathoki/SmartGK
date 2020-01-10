package com.example.smartgk.model;

public class UserLoginModel {
    public Results results;
    public UserLoginModel(Results results) {
        this.results = results;
    }


    public class Results {
        String id, name, image, bio, DOB, address, email, phone_no, slug, validation, banned_status, status, unique_id, created_at, updated_at;

        public Results(String id, String name, String image, String bio, String DOB, String address, String email, String phone_no, String slug, String validation, String banned_status, String status, String unique_id, String created_at, String updated_at) {
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
    public Results getResults() {
        return results;
    }
}
