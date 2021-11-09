package com.pctc.service.impl;

import com.pctc.dao.UserDao;
import com.pctc.model.User;
import com.pctc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;


    @Override
    public int addUser(User user) {
        int count=0;
        if (user!=null){
            userDao.save(user);//save方法，先进行ID查找，如果没有对应的信息则添加信息，有对应的信息则修改信息
            count=1;
        }
        return  count;
    }


    @Override
    public int editUser(User user) {
        int count=0;
        if (user!=null){
            userDao.save(user); //save方法，先进行ID查找，如果没有对应的信息则添加信息，有对应的信息则修改信息
            count=1;
        }
        return  count;
    }

    @Override
    public int deleteUser(Integer id) {
        int count = 0;
        if(id!=null){
            userDao.deleteById(id);
            count = 1;
        }
        return count;
    }

    @Override
    public List<User> findAllUser() {

        List<User> users=userDao.findAll();
        return  users;
    }

    @Override
    public User findUserOne(Integer id) {
        if(id!=null){
            //Optional,不会有空指针的问题
            Optional<User> userOptional = userDao.findById(id);
            if(userOptional.isPresent()){
                User user = userOptional.get();
                return user;
            }
            return null;
        }
        return null;
    }

    @Override
    public List<User> findAllUser(Example example){
        if (example!=null) {
            List<User> users = userDao.findAll(example);
            return users;
        }
        return null;
    }

}
