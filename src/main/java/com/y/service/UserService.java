package com.y.service;

import com.github.pagehelper.Page;
import com.y.bean.User;

public interface UserService {

    Page<User> getAllUser(Integer pageNum, Integer pageSize);

    User getUserByUserName(String userName);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
