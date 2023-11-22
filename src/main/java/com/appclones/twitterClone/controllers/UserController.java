package com.appclones.twitterClone.controllers;

import com.appclones.twitterClone.mappers.UserMapper;
import com.appclones.twitterClone.model.requests.UserRequest;
import com.appclones.twitterClone.model.users.Users;
import com.appclones.twitterClone.services.UserService;
import com.appclones.twitterClone.services.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/signup")
    public ResponseEntity<String> SignUp(@ModelAttribute UserRequest userRequest){
        Users user= userMapper.mapToEntity(userRequest);
        if(userService.SignUp(user)){
            return ResponseEntity.ok("User Registered Success");
        }else{
            return ResponseEntity.ok("User Already Exists");
        }
    }
}
