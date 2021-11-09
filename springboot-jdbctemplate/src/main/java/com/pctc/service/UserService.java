package com.pctc.service;

import com.pctc.model.User;

import java.util.List;

public interface UserService {
    //添加用户
    public void createUser(User user);

    //查询多个对象
    public List<User> getAllUsers();


    //查询单个对象
    public User getUser(Integer id);


    //修改用户
    public void updateUser(User user);


    //删除用户
    public void deleteUser(Integer id);
}
