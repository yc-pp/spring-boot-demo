package com.example.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DemoThymeleafController {

    @GetMapping("/demo")
    public String toDemo(HttpServletRequest request){
        List demoList = new ArrayList();
        for(int i = 0; i < 5; i++){
            Map<String,String> demoMap = new HashMap<>();
            demoMap.put("name","张三" + i);
            demoMap.put("age","5"+i);
            demoList.add(demoMap);
        }
        request.setAttribute("demoList",demoList);
        return "demo";
    }
}
