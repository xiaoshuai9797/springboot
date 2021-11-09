package com.pctc.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource(value = { "classpath:server.properties"})
public class PropertiesController {


    @Value("${server.port}")
    private String port;

    @Value("${server.servlet.path}")
    private String ext;



    @RequestMapping("readPort")
    public String readPort(){
        return port;
    }

    @RequestMapping("readExt")
    public String readExt(){
        return ext;
    }

}
