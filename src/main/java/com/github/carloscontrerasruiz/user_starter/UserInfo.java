package com.github.carloscontrerasruiz.user_starter;

public class UserInfo {

    private UserInfoConfig config;

    public UserInfo(UserInfoConfig config){
        this.config = config;
    }

    public String getUserData(String id){
        return "From starter " + config.getUserInfoProperties().toString() + " " + id + " " + config.getSpaceUrl();
    }
}
