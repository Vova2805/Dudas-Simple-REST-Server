package com.spring.rest.dao.implementation;
import com.spring.rest.dao.interfaces.RatingDao;
import com.spring.rest.entities.Movie;
import com.spring.rest.entities.Rating;
import com.spring.rest.entities.User;
import com.spring.rest.persistence.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Volodymyr Dudas on 29.03.2016.
 */
public class RatingDaoImpl implements RatingDao {

    @Autowired
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    Session session = null;
    Transaction tx = null;

    @Override
    public Rating getRatingById(int id) {
        session = sessionFactory.openSession();
        Rating rating = (Rating) session.load(Rating.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        session.close();
        return rating;
    }

    @Override
    public List<Rating> getRatingsList() {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Rating> ratingList = session.createCriteria(Rating.class).list();
        tx.commit();
        session.close();
        return ratingList;
    }

    @Override
    public List<Task6> performTask6() {
        List<Task6> result = new ArrayList<>();

        session = sessionFactory.openSession();
        tx = session.getTransaction();
        session.beginTransaction();
        List<Rating> ratings = session.createCriteria(Rating.class).list();
        for (Iterator iterator = ratings.iterator(); iterator.hasNext(); ) {
            Rating rating = (Rating) iterator.next();
            Criteria crUser = session.createCriteria(User.class);
            Criteria crMovie = session.createCriteria(Movie.class);

            crUser.add(Restrictions.eq("id", rating.getUserId()));
            crMovie.add(Restrictions.eq("id", rating.getMovieId()));
            List<User> lu = crUser.list();
            User resUser = lu == null ? null : lu.get(0);
            List<Movie> lm = crMovie.list();
            Movie resMovie = lm == null ? null : lm.get(0);

            result.add(new Task6(rating.getRating(),
                    resUser != null ? resUser.getName() : "",
                    resMovie != null ? resMovie.getTitle() : ""
            ));
        }
        tx.commit();
        session.close();
        return result;
    }

    @Override
    public List<Rating> performTask1() {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Criteria cr = session.createCriteria(Rating.class);
        //add restriction
        cr.add(Restrictions.isNull("ratingDate"));
        List<Rating> nullRatings = cr.list();

        Criteria userCR = session.createCriteria(User.class);
        List<User> withNullRatings = new ArrayList<>();
        for (Iterator iterator =
             nullRatings.iterator(); iterator.hasNext(); ) {
            Rating rating = (Rating) iterator.next();
            withNullRatings.add((User) session.load(User.class, new Integer(rating.getUserId())));
        }
        String hql = "UPDATE Rating set ratingDate = :ratingDate " +
                "WHERE ratingDate is NULL";
        Query query = session.createQuery(hql);
        query.setParameter("ratingDate", new Date());
        //int result = query.executeUpdate();
        //System.out.println("Rows affected: " + result);

        List<Rating> ratingList = session.createCriteria(Rating.class).list();
        tx.commit();
        session.close();
        return ratingList;
    }

    @Override
    public List<Task3> performTask3() {
        List<Task3> result = new ArrayList<>();

        session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Rating.class);
        //add restriction
        Criterion rating4 = Restrictions.eq("rating", 4);
        Criterion rating5 = Restrictions.eq("rating", 5);
        LogicalExpression orExp = Restrictions.or(rating4, rating5);
        cr.add(orExp);
        cr.addOrder(Order.asc("ratingDate"));
        List<Rating> ratings = cr.list();

        for (Iterator iterator = ratings.iterator(); iterator.hasNext(); ) {
            Rating rating = (Rating) iterator.next();
            result.add(new Task3(rating.getMovieId(), rating.getRatingDate()));
        }
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();

        return result;

    }
}
