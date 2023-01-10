package com.example.library;

import java.util.ArrayList;
import java.util.List;


import java.util.Objects;
import java.util.Set;

public class User {

    private int id;
    private String name;
    private String username;
    private String password;

    public User(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getUserID() {
        return id;
    }

    public void setUserId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim().toLowerCase();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = username.trim().toLowerCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim().toLowerCase();
    }

    @Override
    public String toString() {
        return "User{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        // check for sign in
        if(user.password != null)  return Objects.equals(username, user.username) && Objects.equals(password, user.password);
        // check for sign up
        return Objects.equals(username, user.username);
    }
}
