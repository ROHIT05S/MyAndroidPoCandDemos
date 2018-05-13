package com.example.rohit.firebasedatabasedemo;

/**
 * Created by Rohit on 10-12-2017.
 */

public class User
{
    public String uname;
    public String email;

    public User() {
    }

    public User(String uname, String email) {
        this.uname = uname;
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public String getEmail() {
        return email;
    }
}
