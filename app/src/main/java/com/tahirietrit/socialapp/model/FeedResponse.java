package com.tahirietrit.socialapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeedResponse {

    @SerializedName("User")
    @Expose
    private List<Postet> postet = null;

    public List<Postet> getPostet() {
        return postet;
    }

    public void setPostet(List<Postet> postet) {
        this.postet = postet;
    }
}