package com.tahirietrit.socialapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeedResponse {

    @SerializedName("postet")
    @Expose
    public List<Posts> postet = null;

    public List<Posts> getPostet() {
        return postet;
    }

    public void setPostet(List<Posts> postet) {
        this.postet = postet;
    }
}