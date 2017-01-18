package com.omg.dao;

import com.omg.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2016/11/20.
 */
public interface UserDao {

    /**
     * 用户名密码查询用户
     * @param userName
     * @param userPassword
     * @return
     */
    User queryByUserNameAndPassword(@Param("userName") String userName,@Param("userPassword") String userPassword);

    /**
     * 根据用户名查询
     * @return
     */
    User queryByUserName(String userName);

    /**
     * 更新数据
     * @param user
     * @return
     */
    int modifyUser(User user);
}
