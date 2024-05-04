package com.example.cab.entity;


public class User {

    private String userDetails;

    public User(String userDetails) {
        this.userDetails = userDetails;
    }

    public String getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(String userDetails) {
        this.userDetails = userDetails;
    }
}

