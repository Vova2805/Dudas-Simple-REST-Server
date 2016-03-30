package com.spring.rest.dao.implementation;


import com.spring.rest.dao.interfaces.MovieDao;
import com.spring.rest.domain.Movie;
import com.spring.rest.domain.Rating;
import com.spring.rest.domain.User;
import com.spring.rest.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Volodymyr Dudas on 29.03.2016.
 */
public class MovieDaoImpl implements MovieDao {

    @Autowired
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    Session session = null;
    Transaction tx = null;

    @Override
    public String deleteAddedMovies() {
       String result = "";
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Movie movie9 = (Movie) session.load(Movie.class,9);
        Movie movie10 = (Movie) session.load(Movie.class,10);
        session.delete(movie9);
        session.delete(movie10);
        tx.commit();
        result = "Movies with id 9 and 10 are deleted";
        session.close();
        return result;
    }

    @Override
    public List<String> performTask4() {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();

        List<String> titles = new ArrayList<>();
        String queryStr = "From Movie where id not in (Select movieId from Rating)";
        Query query = session.createQuery(queryStr);
        List<Movie> movies = query.list();

        for (Iterator iterator = movies.iterator(); iterator.hasNext();) {
            Movie movie = (Movie) iterator.next();
            titles.add(movie.getTitle());
        }

        tx.commit();
        session.close();


        return titles;
    }

    @Override
    public List<Movie> performTask2() {
        Movie movie1 = new Movie(9,"Deadpool","Tim Miller");
        Movie movie2 = new Movie(10,"The 300 spartans","Zak Snyder");
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(movie1);
        session.save(movie2);
        List<Movie> movieList = session.createCriteria(Movie.class).list();
        tx.commit();
        session.close();
        return movieList;
    }

    @Override
    public Movie getMovieById(int id) {
        session = sessionFactory.openSession();
        Movie movie = (Movie) session.load(Movie.class,new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return movie;
    }

    @Override
    public List<Movie> getMoviesList() {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Movie> movieList = session.createCriteria(Movie.class).list();
        tx.commit();
        session.close();
        return movieList;
    }
}
