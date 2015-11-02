package com.tuanna.retrofitdemo.API;

import com.tuanna.retrofitdemo.API.core.ApiClient;
import com.tuanna.retrofitdemo.model.User;

import retrofit.Call;
import retrofit.Callback;

/**
 * Project RetrofitDemo.
 * Copyright © 2015.
 * Created by tuanna.
 */
public class ApiAuth {
    public static void getUser(String userName, Callback callback){
        Call<User> call = ApiClient.Builder().getUser(userName);
        call.enqueue(callback);
    }
}
