package com.pctc;

import com.pctc.model.User;
import com.pctc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootJdbctemplateApplicationTests {

    @Autowired
    private UserService userService;


    @Test
    void contextLoads() {
    }

    @Test
    public void userTest(){

        User user=new User();
        user.setName("吴优");
        user.setAge(28);
        userService.createUser(user);
        System.out.println("整合springboot 与junit结束");
    }


    @Test
    public void testGetAllUsers(){
      List<User> list = userService.getAllUsers();
        System.out.println(list);
    }


    @Test
    public void testGetUsers(){

     User user= userService.getUser(1);
        System.out.println(user);

    }


    @Test
    public void testUpdate(){

        User user = new User();
        user.setId(3);
        user.setName("熊腾");
        user.setAge(21);
        userService.updateUser(user);
    }


    @Test
    public void testDelete(){

        userService.deleteUser(4);
    }

}
