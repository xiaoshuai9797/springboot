/*
package com.pctc;

import com.pctc.model.User;
import com.pctc.service.UserService;
import org.springframework.data.domain.Example;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootSpringjpaApplicationTests {

    @Resource
    private UserService userService;


    @Test
    void contextLoads() {
    }


    @Test
    public void testAddUser(){
        User user=new User();
        user.setId(9);
        user.setName("汪炳");
        user.setAge(22);

        int count=userService.addUser(user);
        System.out.println(count);
    }


    @Test
    public void testEditUser(){
        User user=new User();
        user.setId(9);
        user.setName("汪炳剑");
        user.setAge(21);
        int count=userService.editUser(user);
        System.out.println(count);
    }


    @Test
    public void testDeleteUser(){
        int count=userService.deleteUser(5);
        System.out.println(count);
    }


    @Test
    public void testFindAllUser(){
        List<User> list=userService.findAllUser();
        for(User user:list) {
            System.out.println(user);
        }
    }


    @Test
    public void testFindUserById(){
       User user = userService.findUserOne(1);
        System.out.println(user);
    }


    @Test
    public void testFindAllUserExample(){
        User user=new User();
        user.setName("肖帅");
        Example<User> example = Example.of(user);
        List<User> users = userService.findAllUser(example);
        System.out.println(users);
    }


    @Test
    public void testAddUsers(){
        User user1 = new User();
        user1.setName("xs1");
        user1.setAge(21);

        User user2 = new User();
        user2.setName("xs2");
        user2.setAge(22);

        int count=userService.addUsers(user1,user2);
        System.out.println(count);
    }


    @Test
    public void testAddUsersLog(){
        User user1 = new User();
        user1.setName("xs3");
        user1.setAge(23);

        User user2 = new User();
        user2.setName("xs4");
        user2.setAge(24);

        userService.addUsersLog(user1,user2);

    }




}
*/
