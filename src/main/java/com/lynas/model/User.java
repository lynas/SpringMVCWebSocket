package com.lynas.model;

/**
 * Created by sazzad on 2/15/16
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }
}
