package com.kshrd.oauth2spring.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class TestUser {
    @GetMapping("/hello")
    public String hello(){
        return "hello data";
    }

}