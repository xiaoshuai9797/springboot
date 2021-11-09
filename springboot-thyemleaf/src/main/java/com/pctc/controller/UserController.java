package com.pctc.controller;


import com.pctc.model.User;
import com.pctc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;


    //http://localhost:8080/find?id=1
    @RequestMapping("/find")
    public User find(Integer id) {
        User findUser = userService.findUserOne(id);
        System.out.println("springboot热部署");
        return findUser;
    }


    //http://localhost:8080/userSave?name=肖帅&age=22
    @RequestMapping("/userSave")
    public int userSave(User user) {
        int count=userService.addUser(user);
        return count;
    }


    //http://localhost:8080/findAllUser
    @RequestMapping("/findAllUser")
    public List<User> findAllUser(){
        List<User> lists= userService.findAllUser();
        System.out.println("springboot热部署");
        return lists;
    }

}
