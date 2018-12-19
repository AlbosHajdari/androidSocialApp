package com.tahirietrit.socialapp.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicefactory {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://appsix.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
