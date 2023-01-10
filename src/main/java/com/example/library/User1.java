package com.example.library;

public class User1 {
     private String firstName, lastName, cin, phone, email;


    public User1(String firstName, String lastName, String cin, String phone, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.phone = phone;
        this.email = email;
    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
