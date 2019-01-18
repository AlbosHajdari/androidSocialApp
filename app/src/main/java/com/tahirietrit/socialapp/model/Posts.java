package com.tahirietrit.socialapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Posts {

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
}