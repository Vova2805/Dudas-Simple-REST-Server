package com.spring.rest.dao.implementation;


import com.spring.rest.dao.interfaces.UserDao;
import com.spring.rest.domain.User;
import com.spring.rest.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Volodymyr Dudas on 29.03.2016.
 */
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    Session session = null;
    Transaction tx = null;

    @Override
    public User getUserById(int id) {
        session = sessionFactory.openSession();
        User user = (User) session.load(User.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return user;
    }

    @Override
    public List<User> getUsersList() {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<User> userList = session.createCriteria(User.class).list();
        tx.commit();
        session.close();
        return userList;
    }
}
