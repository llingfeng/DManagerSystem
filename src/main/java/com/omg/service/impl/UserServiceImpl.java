package com.omg.service.impl;

import com.omg.dao.UserDao;
import com.omg.entity.User;
import com.omg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2016/11/20.
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUserNameAndPassword(String userName, String userPassword) {
        return userDao.queryByUserNameAndPassword(userName,userPassword);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.queryByUserName(userName);
    }

    @Override
    public int updateUser(User user) {
        return userDao.modifyUser(user);
    }
}
