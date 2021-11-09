package com.pctc.service;

import com.pctc.model.User;

public interface UserService {

    public int insert(User user);

    public User findById(Integer id);

    public int updateUser(User user);


    public int deleteUser(int id);
}
