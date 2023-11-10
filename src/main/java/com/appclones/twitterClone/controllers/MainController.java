package com.appclones.twitterClone.controllers;

import com.appclones.twitterClone.mappers.TweetMapper;
import com.appclones.twitterClone.model.Tweets;
import com.appclones.twitterClone.model.responses.TweetResponse;
import com.appclones.twitterClone.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    TweetService tweetService;
    @Autowired
    TweetMapper tweetMapper;

    /*this function is to read tweets from tweets table and show on home page*/
    @GetMapping({"/", "/home"})
    public String getTweets(Model model) {
        List<Tweets> tweets = tweetService.getAllTweets();
        List<Tweets> descendingOrderTweets = tweets.stream()
                .sorted(Comparator.comparing(Tweets::getTime).reversed())
                .toList();
        List<TweetResponse> tweetResponses = descendingOrderTweets.stream()
                .map(tweets1 -> tweetMapper.mapToDTO(tweets1))
                .toList();

        model.addAttribute("tweets", tweetResponses);
        return "home";
    }
}
