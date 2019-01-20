package com.tahirietrit.socialapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Posts implements Parcelable {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("user_id")
    @Expose
    public String userId;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("photo_url")
    @Expose
    public String photoUrl;
    @SerializedName("pershkrimi")
    @Expose
    public String pershkrimi;
    @SerializedName("created_date")
    @Expose
    public String createdDate;

    protected Posts(Parcel in) {
        id = in.readString();
        userId = in.readString();
        username = in.readString();
        photoUrl = in.readString();
        pershkrimi = in.readString();
        createdDate = in.readString();
    }

    public static final Creator<Posts> CREATOR = new Creator<Posts>() {
        @Override
        public Posts createFromParcel(Parcel in) {
            return new Posts(in);
        }

        @Override
        public Posts[] newArray(int size) {
            return new Posts[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String userIdid) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String id) {
        this.username = username;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String id) {
        this.photoUrl = photoUrl;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String id) {
        this.pershkrimi = pershkrimi;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String id) {
        this.createdDate = createdDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(userId);
        dest.writeString(username);
        dest.writeString(photoUrl);
        dest.writeString(pershkrimi);
        dest.writeString(createdDate);
    }
}