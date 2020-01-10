package com.example.smartgk.Database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class UserDetails implements Parcelable {

    @PrimaryKey
    @NonNull
    public final String id;
    public final String name;
    public final String image;
    public final String bio;

    public final String address;
    public final String email;
    public final String phone_no;
    public final String slug;
    public final String validation;
    public final String created_at;
    public final String updated_at;

    public UserDetails( @NonNull String id, String name, String image, String bio,  String address, String email, String phone_no, String slug, String validation, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.bio = bio;
        this.address = address;
        this.email = email;
        this.phone_no = phone_no;
        this.slug = slug;
        this.validation = validation;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    protected UserDetails(Parcel in) {
        id = in.readString();
        name = in.readString();
        image = in.readString();
        bio = in.readString();
        address = in.readString();
        email = in.readString();
        phone_no = in.readString();
        slug = in.readString();
        validation = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
    }

    public static final Creator<UserDetails> CREATOR = new Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel in) {
            return new UserDetails(in);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[size];
        }
    };

    @NonNull
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getBio() {
        return bio;
    }


    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getSlug() {
        return slug;
    }

    public String getValidation() {
        return validation;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public static Creator<UserDetails> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(bio);
        dest.writeString(address);
        dest.writeString(email);
        dest.writeString(phone_no);
        dest.writeString(slug);
        dest.writeString(validation);
        dest.writeString(created_at);
        dest.writeString(updated_at);
    }
}
