package com.pctc.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exception {
    @RequestMapping("/xs")
    public String getError1() {
        int a=100;
        int b=0;
        int c=a/b;
        return "success";
    }


    @RequestMapping("/xs1")
    public void getError2() {
        int a=100;
        int b=0;
        int c=a/b;
    }

}
