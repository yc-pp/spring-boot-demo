package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBootController {
    @RequestMapping("/demo")
    public String demo(){
        return "hello Spring Boot";
    }
}
