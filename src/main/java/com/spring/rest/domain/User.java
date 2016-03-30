package com.spring.rest.domain;

import java.io.Serializable;

/**
 * Created by Volodymyr Dudas on 29.03.2016.
 */

public class User  implements Serializable {
    private java.lang.Integer id;
    private String name;

    public User() {
    }

    public User(java.lang.Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public java.lang.Integer getId() {
        return id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
