package com.pctc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class ThymeleafController {



    @RequestMapping("/show")
    public String showInfo(Model model) {

        model.addAttribute("msg", "我是第一个thymeleaf案例");
        model.addAttribute("sex","女");

        model.addAttribute("id",1);

        List<String> nameList = new ArrayList<String>();
        nameList.add("zhangsan");
        nameList.add("lisi");
        nameList.add("wangwu");

        model.addAttribute("list", nameList);

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "张三");
        map.put("2", "李四");
        map.put("3", "王五");

        model.addAttribute("map", map);


        model.addAttribute("date",new Date());


        return "thymeleafdemo";
    }







    @RequestMapping("/show1")
    public String showInfo1(Model model,int id,String name) {
        model.addAttribute("msg", "我是第一个thymeleaf案例");
        model.addAttribute("sex","女");
        System.out.println(id);
        System.out.println(name);
        return "thymeleafdemo";
    }



    @RequestMapping("/path/{id}/show2")
    public String showInfo2(Model model, @PathVariable String id, String name) {
        model.addAttribute("msg", "我是第一个thymeleaf案例");
        model.addAttribute("sex","女");

        List<String> nameList = new ArrayList<String>();
        nameList.add("zhangsan");
        nameList.add("lisi");
        nameList.add("wangwu");

        model.addAttribute("list", nameList);

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "张三");
        map.put("2", "李四");
        map.put("3", "王五");

        model.addAttribute("map", map);

        System.out.println(id);
        System.out.println(name);

        return "thymeleafdemo";
    }




    @RequestMapping("/path/{id}/{name}/show3")
    public String showInfo3(Model model,@PathVariable String id, @PathVariable String name) {

        model.addAttribute("msg", "我是第一个thymeleaf案例");
        model.addAttribute("sex","女");

        List<String> nameList = new ArrayList<String>();
        nameList.add("zhangsan");
        nameList.add("lisi");
        nameList.add("wangwu");

        model.addAttribute("list", nameList);

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "张三");
        map.put("2", "李四");
        map.put("3", "王五");

        model.addAttribute("map", map);

        System.out.println(id);
        System.out.println(name);


        return "thymeleafdemo";
    }




    @RequestMapping("/index")
    public String index(){
        return  "index";
    }





}
