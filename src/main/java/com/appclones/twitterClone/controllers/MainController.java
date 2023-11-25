package com.appclones.twitterClone.controllers;

import com.appclones.twitterClone.mappers.ReplyMapper;
import com.appclones.twitterClone.mappers.TweetMapper;
import com.appclones.twitterClone.mappers.UserMapper;
import com.appclones.twitterClone.model.Replies;
import com.appclones.twitterClone.model.Tweets;
import com.appclones.twitterClone.model.responses.ReplyResponse;
import com.appclones.twitterClone.model.responses.TweetResponse;
import com.appclones.twitterClone.model.responses.UserResponse;
import com.appclones.twitterClone.model.users.Users;
import com.appclones.twitterClone.services.ReplyService;
import com.appclones.twitterClone.services.TweetService;
import com.appclones.twitterClone.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    TweetService tweetService;
    @Autowired
    UserService userService;
    @Autowired
    TweetMapper tweetMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ReplyService replyService;
    @Autowired
    ReplyMapper replyMapper;

    /*this function is to read tweets from tweets table and show on home page*/
    @GetMapping({"/", "/home"})
    public String getTweets( Model model) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();
        Users user = userService.findByUsername(username);

        List<Tweets> tweets = tweetService.getAllTweets();
        List<Tweets> descendingOrderTweets = tweets.stream()
                .sorted(Comparator.comparing(Tweets::getTime).reversed())
                .toList();
        List<TweetResponse> tweetResponses = descendingOrderTweets.stream()
                .map(tweets1 -> tweetMapper.mapToDTO(tweets1))
                .toList();

        List<Tweets> userTweets = tweetService.getUserTweets(username);
        List<Tweets> descendingOrderUserTweets = userTweets.stream()
                .sorted(Comparator.comparing(Tweets::getTime).reversed())
                .toList();
        List<TweetResponse> userTweetsResponse = descendingOrderUserTweets.stream()
                .map(tweets1 -> tweetMapper.mapToDTO(tweets1))
                .toList();

        UserResponse userResponse = userMapper.mapToDTO(user);

        List<Replies> repliesList = replyService.getYourOwnReplies(username);
        List<ReplyResponse> repliesResposes = repliesList.stream()
                .map(reply -> replyMapper.mapToDTO(reply) )
                .toList();

        model.addAttribute("tweets", tweetResponses);
        model.addAttribute("userTweets", userTweetsResponse);
        model.addAttribute("user", userResponse);
        model.addAttribute("userReplies", repliesResposes);

        return "home";
    }

}
