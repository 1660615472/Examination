package com.cheer.model;
//javabean admin
import java.io.Serializable;

public class Admin implements Serializable {
    private String username;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Admin(){

    }

    private String password;

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
