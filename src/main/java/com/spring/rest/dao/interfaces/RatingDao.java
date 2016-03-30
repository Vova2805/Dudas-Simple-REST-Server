package com.spring.rest.dao.interfaces;

import com.spring.rest.entities.Rating;

import java.util.Date;
import java.util.List;

/**
 * Created by Volodymyr Dudas on 29.03.2016.
 */
public interface RatingDao {
    Rating getRatingById(int id);

    List<Rating> getRatingsList();

    List<Rating> performTask1();

    List<Task3> performTask3();

    List<Task6> performTask6();

    class Task3 {
        private int movieID;
        private Date ratingDate;

        public Task3() {
        }

        public Task3(int movieID, Date ratingDate) {
            this.movieID = movieID;
            this.ratingDate = ratingDate;
        }

        public int getMovieID() {
            return movieID;
        }

        public void setMovieID(int movieID) {
            this.movieID = movieID;
        }

        public Date getRatingDate() {
            return ratingDate;
        }

        public void setRatingDate(java.sql.Date ratingDate) {
            this.ratingDate = ratingDate;
        }
    }

    class Task6 {
        private int rating;
        private String userName;
        private String movieTitle;

        public Task6() {
        }

        public Task6(int rating, String userName, String movieTitle) {
            this.rating = rating;
            this.userName = userName;
            this.movieTitle = movieTitle;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getMovieTitle() {
            return movieTitle;
        }

        public void setMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
        }
    }

}
