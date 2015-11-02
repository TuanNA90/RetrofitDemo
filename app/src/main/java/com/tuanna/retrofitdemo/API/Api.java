package com.tuanna.retrofitdemo.API;

import com.tuanna.retrofitdemo.model.User;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Project RetrofitDemo.
 * Copyright © 2015.
 * Created by tuanna.
 */
public interface Api {
    /**
     * Request method and URL specified in the annotation
     * Callback for the parsed response is the last parameter
     *
     * @param username
     * @return
     */
    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
