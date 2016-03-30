package com.spring.rest.dao.interfaces;


import com.spring.rest.entities.User;

import java.util.List;

/**
 * Created by Volodymyr Dudas on 29.03.2016.
 */
public interface UserDao {
    User getUserById(int id);

    List<User> getUsersList();
}
