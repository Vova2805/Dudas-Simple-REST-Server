package com.spring.rest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Volodymyr Dudas on 29.03.2016.
 */

public class Movie   implements Serializable {
    private java.lang.Integer id;
    private String title;
    private String director;

    public Movie() {
    }

    public Movie(java.lang.Integer id, String title, String director) {
        this.id = id;
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public java.lang.Integer getId() {
        return id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
