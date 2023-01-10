package com.example.library.models;

public class User {
    public String FirstName;
    public String LastName;
    public String cin;
    public String phoneNumber;
    public String email;
    public User(String FirstName,String LastName,String cin,String phoneNumber,String email){
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.cin=cin;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
    public User(){

    }

    @Override
    public String toString() {
        return "current User format json:{" +
                "First Name='" + FirstName + '\'' +
                ",Last name='" + LastName + '\'' +
                ", cin='" + cin + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
