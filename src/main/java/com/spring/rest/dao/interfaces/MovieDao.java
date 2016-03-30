package com.spring.rest.dao.interfaces;


import com.spring.rest.domain.Movie;

import java.sql.Date;
import java.util.List;

/**
 * Created by Volodymyr Dudas on 29.03.2016.
 */
public interface MovieDao {
    Movie getMovieById(int id) ;
    List<Movie> getMoviesList() ;
    List<Movie> performTask2() ;
    List<String> performTask4();
    String deleteAddedMovies();

}
