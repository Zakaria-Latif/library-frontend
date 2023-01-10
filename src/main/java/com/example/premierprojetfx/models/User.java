package com.example.premierprojetfx.models;

public class User {
    public String id;
    public String name;
    public String cin;
    public String phoneNumber;
    public String email;
    public User(String id,String name,String cin,String phoneNumber,String email){
        this.id=id;
        this.name=name;
        this.cin=cin;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
    public User(){

    }

    @Override
    public String toString() {
        return "current User format json:{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cin='" + cin + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
