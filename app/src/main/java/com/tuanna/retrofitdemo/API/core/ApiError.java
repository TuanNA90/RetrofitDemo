package com.tuanna.retrofitdemo.API.core;

import lombok.Data;
import lombok.experimental.Builder;

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
