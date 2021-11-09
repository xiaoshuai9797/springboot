package com.pctc.action;

import com.pctc.model.User;
import com.pctc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;


    @RequestMapping("/addUserUi")
    public String addUserUi(User user) {
        System.out.println("addUserUi");
        System.out.println("springboot热部署");
        return "add";
    }



   /* @RequestMapping("/addUser")
    public String add(User user) {
        //后端处理,用户自定义的。没有使用任何框架
      *//*  if("".equals(user.getName())||user.getName()==null){
            throw new RuntimeException(" 用户名不能为空");
        }*//*

     *//*  if(user.getAge()==null){
            throw new RuntimeException(" 年龄不能为空");
        }*//*

        //调用添加用户的service
        userService.addUser(user);
        System.out.println(user.getAge());
        System.out.println(user.getName());
        System.out.println("addUser");
        System.out.println("springboot热部署");
        return "add";
    }
*/



    @RequestMapping("/addUser")
    public String add(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }

        //调用添加用户的service
        userService.addUser(user);
        System.out.println(user.getAge());
        System.out.println(user.getName());
        System.out.println("addUser");
        return "add";
    }

    @RequestMapping("/selectUser")
    public String select(Model model) {

        //调用用户查询的sevice
        List<User> userList = userService.findAllUser();

        model.addAttribute("userList", userList);

        return "list";
    }


    @RequestMapping("/editUserUi")
    public String editUserUi(Integer id, Model model) {

        // 调用用户的 根据id查询用户对象的service方法
        User user = userService.findUserOne(id);

        model.addAttribute("user", user);

        return "edit";
    }


    @RequestMapping("/editUser")
    public String edit(User user) {

        //调用用户的 修改数据的service方法
        userService.editUser(user);

        return "redirect:/user/selectUser";

    }




    @RequestMapping("/deleteUser")
    public String delete(Integer id) {

        //调用用户的根据用户id删除
        userService.deleteUser(id);

        return "redirect:/user/selectUser";
    }


}
