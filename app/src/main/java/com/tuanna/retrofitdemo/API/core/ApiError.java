package com.tuanna.retrofitdemo.API.core;

import lombok.Builder;
import lombok.Data;

/**
 * Project RetrofitDemo.
 * Copyright © 2015.
 * Created by tuanna.
 */
@Data
@Builder
public class ApiError {
    private String message;
}
