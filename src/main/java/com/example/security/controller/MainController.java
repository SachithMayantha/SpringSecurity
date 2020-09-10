package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String main() {
        System.out.println("return main view");
        return "main";
    }

    @RequestMapping("/login")
    public String login() {
        System.out.println("return login view");
        return "login";
    }

    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }
}
