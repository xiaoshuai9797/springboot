package com.pctc.service.impl;

import com.pctc.dao.UserMapper;
import com.pctc.model.User;
import com.pctc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public int insert(User user) {
        if (user!=null) {
            return userMapper.insert(user.getName(), user.getAge());
        }else{
            return  0;
        }
    }

    @Override
    public User findById(Integer id) {
       User user =  userMapper.findById(id);
       return user;
    }

    @Override
    public int updateUser(User user) {
        if (user!=null){
            return userMapper.updateUser(user);}
        else{
            return  0;
        }
    }

    @Override
    public int deleteUser(int id) {
        if (id>=0){
            return userMapper.deleteUser(id);}
        else{
            return 0;
        }
    }
}
