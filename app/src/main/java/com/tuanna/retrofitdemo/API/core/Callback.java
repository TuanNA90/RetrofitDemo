package com.tuanna.retrofitdemo.API.core;

import lombok.NoArgsConstructor;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Project RetrofitDemo.
 * Copyright © 2015.
 * Created by tuanna.
 */
@NoArgsConstructor
public abstract class Callback<T> implements retrofit.Callback<T> {

    public abstract void onResponse(Response<T> t);

    public abstract void onFailure(Error error);

    /**
     * Successful HTTP response.
     *
     * @param response
     * @param retrofit
     */
    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {
        onResponse(response);
    }

    /**
     * Invoked when a network or unexpected exception occurred during the HTTP request.
     *
     * @param t
     */
    @Override
    public void onFailure(Throwable t) {
        onFailure(Error.builder()
                .stateCode(0)
                .message(t.getMessage())
                .build());
    }
}
