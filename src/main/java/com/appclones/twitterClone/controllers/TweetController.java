package com.appclones.twitterClone.controllers;

import com.appclones.twitterClone.mappers.TweetMapper;
import com.appclones.twitterClone.model.Tweets;
import com.appclones.twitterClone.model.requests.TweetRequest;
import com.appclones.twitterClone.model.users.Users;
import com.appclones.twitterClone.services.TweetService;
import com.appclones.twitterClone.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/tweet")
public class TweetController {
    private static final Logger logger = LoggerFactory.getLogger(TweetController.class);
    @Autowired
    UserService userService;
    @Autowired
    TweetMapper tweetMapper;
    @Autowired
    TweetService tweetService;

    @RequestMapping(method = {RequestMethod.POST}, value = "/save")
    public String saveTweet(@ModelAttribute TweetRequest tweetRequest) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();
        Users user = userService.findByUsername(username);

        Tweets tweet = tweetMapper.mapToEntity(tweetRequest, user);
        if (tweetService.saveTweet(tweet)){
            return "redirect:/home";
        }else{
            return "redirect:/home";
        }
    }
    @RequestMapping(value = "/updateLikes", method = {RequestMethod.GET,RequestMethod.POST})
    public String updateLikes(@RequestParam("id") Integer tweetId) {
        tweetService.updateLikes(tweetId);
        return "redirect:/home";
    }


}
