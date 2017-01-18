package com.omg.service;

import com.omg.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2016/11/20.
 */
public interface UserService{

    /**
     * 根据用户秘密查询用户
     * @param userName
     * @param password
     * @return
     */
    User getUserByUserNameAndPassword(String userName, String password);

    /**
     * 根据用户名称查询
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 更新
     * @param user
     * @return
     */
    int updateUser(User user);
}
