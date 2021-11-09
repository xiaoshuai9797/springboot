package com.pctc.controller;


import com.pctc.model.User;
import com.pctc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public String getUserList(Map<String, List<User>> map){
        List<User> users=userService.getAllUsers();
        map.put("users", users);
        return "userList";
    }

}
