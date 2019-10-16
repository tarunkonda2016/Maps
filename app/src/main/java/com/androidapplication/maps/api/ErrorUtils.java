package com.androidapplication.maps.api;

import android.util.Log;


import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

class ErrorUtils {
    public static APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter = RestClient.retrofit().responseBodyConverter(APIError.class, new Annotation[0]);
        APIError error=null;
        try {
            assert response.errorBody() != null;
            error = converter.convert(response.errorBody());
        } catch (Exception e) {

        }
        return error;
    }
}