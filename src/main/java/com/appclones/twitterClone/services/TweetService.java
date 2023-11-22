package com.appclones.twitterClone.services;

import com.appclones.twitterClone.model.Tweets;
import jakarta.transaction.Transactional;

import java.util.List;

public interface TweetService {
    @Transactional
    boolean saveTweet(Tweets tweet);

    @Transactional
    public List<Tweets> getAllTweets();

    @Transactional
    public void updateLikes(Integer tweetId);

    @Transactional
    public  List<Tweets> getUserTweets(String username);

    @Transactional
    public  Tweets findTweetById(Integer id);
}
