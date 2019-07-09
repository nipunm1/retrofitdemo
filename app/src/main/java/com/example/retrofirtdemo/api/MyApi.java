package com.example.retrofirtdemo.api;

import com.example.retrofirtdemo.model.Sirfollowers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApi {

    @GET("/users/{user}/followers")
    Call<List<Sirfollowers>> getFollowers(@Path("user") String user);
}
