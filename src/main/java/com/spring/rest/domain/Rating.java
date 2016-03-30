package com.spring.rest.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Volodymyr Dudas on 29.03.2016.
 */

public class Rating  implements Serializable {
    private java.lang.Integer id;
    private java.lang.Integer rating;
    private Date ratingDate;
    private java.lang.Integer userId;
    private java.lang.Integer movieId;

    public Rating() {
    }

    public Rating(java.lang.Integer id, java.lang.Integer rating, Date ratingDate, java.lang.Integer userId, java.lang.Integer movieId) {
        this.id = id;
        this.rating = rating;
        this.ratingDate = ratingDate;
        this.userId = userId;
        this.movieId = movieId;
    }

    public java.lang.Integer getId() {
        return id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.Integer getRating() {
        return rating;
    }

    public void setRating(java.lang.Integer rating) {
        this.rating = rating;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }

    public java.lang.Integer getUserId() {
        return userId;
    }

    public void setUserId(java.lang.Integer userId) {
        this.userId = userId;
    }

    public java.lang.Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(java.lang.Integer movieId) {
        this.movieId = movieId;
    }
}
