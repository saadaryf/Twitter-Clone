package com.appclones.twitterClone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/login")
    @ResponseBody
    public String loggedIN(){
        return "Login data received";
    }
}
