package com.appclones.twitterClone.controllers;

import com.appclones.twitterClone.mappers.ReplyMapper;
import com.appclones.twitterClone.mappers.TweetMapper;
import com.appclones.twitterClone.model.Replies;
import com.appclones.twitterClone.model.Tweets;
import com.appclones.twitterClone.model.requests.ReplyRequest;
import com.appclones.twitterClone.model.requests.TweetRequest;
import com.appclones.twitterClone.model.responses.ReplyResponse;
import com.appclones.twitterClone.model.users.Users;
import com.appclones.twitterClone.services.ReplyService;
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
import java.util.stream.Collectors;

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
    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    ReplyService replyService;

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
    @RequestMapping(method = {RequestMethod.POST ,RequestMethod.GET}, value = "/save-reply")
    public String saveReply(@RequestParam("tweetId") Integer tweetId, @RequestParam("content") String content){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();
        Users user = userService.findByUsername(username);

        ReplyRequest replyRequest = new ReplyRequest();
        replyRequest.setId(tweetId);
        replyRequest.setContent(content);

        Tweets tweet = tweetService.findTweetById(tweetId);

        Replies reply = replyMapper.mapToEntity(replyRequest, user, tweet);
        replyService.saveReply(reply);
        return "redirect:/home";
    }
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/get-replies")
    public String getReplies(@RequestParam("id") Integer tweetId, Model model){
        List<Replies> repliesList = replyService.getRepliesOfTweet(tweetId);
        List<ReplyResponse> replyResponses= repliesList.stream()
                .map(reply -> replyMapper.mapToDTO(reply))
                .toList();
        model.addAttribute("tweetReplies" ,replyResponses);
        return "replies";
    }
    @GetMapping("/updateLikes")
    public String updateLikes(@RequestParam("id") Integer tweetId) {
        tweetService.updateLikes(tweetId);
        return "redirect:/";
    }
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/delete")
    public String deleteTweet(@RequestParam("id") Integer tweetId){
        tweetService.deleteTweet(tweetId);
        return "redirect:/home";
    }

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/delete-reply")
    public String deleteReply(@RequestParam("id") Integer replyId){
        replyService.deleteReply(replyId);
        return "redirect:/home";
    }


}
