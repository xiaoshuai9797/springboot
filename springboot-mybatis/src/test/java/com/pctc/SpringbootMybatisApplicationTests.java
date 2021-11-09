package com.pctc;

import com.pctc.model.User;
import com.pctc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }


    @Test
    public void userTestInsertMany(){

        for(int i=0;i<5;i++) {
            User user = new User();
            user.setName("xiao"+i);
            user.setAge(22+i);
            System.out.println(userService.insert(user));
        }
        System.out.println("整合springboot 与junit结束");
    }


    @Test
    public void TestFindById(){
        User user=userService.findById(1);
        System.out.println(user);
    }


    @Test
    public void TestUpdate(){
        User user=new User();
        user.setId(2);
        user.setName("温帅");
        user.setAge(22);
        System.out.println(userService.updateUser(user));

    }


    @Test
    public void TestDelete(){
        System.out.println(userService.deleteUser(6));
    }

}
