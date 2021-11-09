package com.pctc.service.impl;

import com.pctc.dao.UserDao;
import com.pctc.model.User;
import com.pctc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public void createUser(User user) {
        if (user!=null){
            userDao.createUser(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
      List<User> list = userDao.getAllUsers();
      return list;
    }

    @Override
    public User getUser(Integer id) {
        User user = userDao.getUser(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
