package com.example.library;

public final class UserToken {
    private static UserToken instance;

    public static String token;

    private UserToken(String token) {
        this.token = token;
    }

    public static UserToken getInstance(String token) {
        if(instance == null) {
            instance = new UserToken(token);
        }
        return instance;
    }


    public void cleanUserToken() {
        token = null;
    }

}