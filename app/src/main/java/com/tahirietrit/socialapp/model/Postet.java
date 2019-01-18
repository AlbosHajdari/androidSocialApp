package com.tahirietrit.socialapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Postet {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("UserID")
    @Expose
    private String userId;
    @SerializedName("UserName")
    @Expose
    private String username;
    @SerializedName("photoURL")
    @Expose
    private String photoUrl;
    @SerializedName("pershkrimi")
    @Expose
    private String pershkrimi;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPhotoUrl() {
        return photoUrl;
    }


    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }


    public String getPershkrimi() {
        return pershkrimi;
    }


    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }


    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}