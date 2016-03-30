package com.spring.rest.controllers;

import com.spring.rest.dao.implementation.MovieDaoImpl;
import com.spring.rest.dao.implementation.RatingDaoImpl;
import com.spring.rest.dao.implementation.UserDaoImpl;
import com.spring.rest.dao.interfaces.MovieDao;
import com.spring.rest.dao.interfaces.RatingDao;
import com.spring.rest.dao.interfaces.UserDao;
import com.spring.rest.domain.Movie;
import com.spring.rest.domain.Rating;
import com.spring.rest.domain.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Volodymyr Dudas on 29.03.2016.
 */
@Controller
@RequestMapping(value = "/myservice")
public class RestController {

    private static UserDao userService;
    private static MovieDao movieService;
    private static RatingDao ratingService;

    static {
        userService = new UserDaoImpl();
        movieService = new MovieDaoImpl();
        ratingService = new RatingDaoImpl();
    }


    //task0users Return all users
    @RequestMapping(value = "/task0users", method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> getAllUsers() {
        List<User> usersList =  userService.getUsersList();
        return usersList;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    User getUser(@PathVariable int id) {
        User user =  userService.getUserById(id);
        return user;
    }

    //task0users Return all users
    @RequestMapping(value = "/task0movies", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Movie> getAllMovies() {
        List<Movie> moviesList =  movieService.getMoviesList();
        return moviesList;
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Movie getMovie(@PathVariable int id) {
        Movie movie =  movieService.getMovieById(id);
        return movie;
    }

    //task0users Return all users
    @RequestMapping(value = "/task0ratings", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Rating> getAllRatings() {
        List<Rating> ratingsList =  ratingService.getRatingsList();
        return ratingsList;
    }

    @RequestMapping(value = "/ratings/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Rating getRating(@PathVariable int id) {
        Rating rating =  ratingService.getRatingById(id);
        return rating;
    }

    @RequestMapping(value = "/task1", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Rating> getAllRatings1() {
        List<Rating> ratingsList =  ratingService.performTask1();
        return ratingsList;
    }


    @RequestMapping(value = "/task2", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Movie> getMovies2() {
        List<Movie> moviesList =  movieService.performTask2();
        return moviesList;
    }

    @RequestMapping(value = "/task3", method = RequestMethod.GET)
    public
    @ResponseBody
    List<RatingDao.Task3> getRatings3() {
        List<RatingDao.Task3> ratings =  ratingService.performTask3();
        return ratings;
    }

    @RequestMapping(value = "/task4", method = RequestMethod.GET)
    public
    @ResponseBody
    List<String> getTitles() {
        List<String> titles =  movieService.performTask4();
        return titles;
    }

    @RequestMapping(value = "/task5", method = RequestMethod.GET)
    public
    @ResponseBody
    String deleteMovies() {
        String res = movieService.deleteAddedMovies();
        return res;
    }

    @RequestMapping(value = "/task6", method = RequestMethod.GET)
    public
    @ResponseBody
    List<RatingDao.Task6> getGroups() {
        List<RatingDao.Task6> result = ratingService.performTask6();
        return result;
    }
}
