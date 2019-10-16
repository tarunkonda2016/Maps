package com.androidapplication.maps.api;

public class APIError {
    private int statusCode;
    private String message;
    private String title;

    public APIError() {
    /*
        this is called for error in api
     */
    }

    public int status() {
        return statusCode;
    }
    public String message() {
        return message;
    }
    public String getTitle() {
        return title;
    }


}