package com.pctc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class FreeMarkController {

    @RequestMapping("/xs2")
    public String hi(Map<String,Object> map){
        map.put("xiaoshuai","大家好咯");
        return "hello";
    }


    @RequestMapping("/freemarkerIndex")
    public String index(Map<String, Object>result) {
        result.put("name", "xs");
        result.put("sex", "0");

        List<String> listResult = new ArrayList<String>();
        listResult.add("zhangsan");
        listResult.add("lisi");
        listResult.add("softjx");
        result.put("listResult", listResult);

        return "index";
    }
}
