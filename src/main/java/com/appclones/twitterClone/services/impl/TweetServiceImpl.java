package com.appclones.twitterClone.services.impl;

import com.appclones.twitterClone.model.Tweets;
import com.appclones.twitterClone.model.users.Users;
import com.appclones.twitterClone.repositories.TweetsRepository;
import com.appclones.twitterClone.repositories.UserRepository;
import com.appclones.twitterClone.services.TweetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TweetServiceImpl implements TweetService {
    private static final Logger logger = LoggerFactory.getLogger(TweetServiceImpl.class);

    @Autowired
    TweetsRepository tweetsRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean saveTweet(Tweets tweet) {
        try {
            tweetsRepository.save(tweet);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Tweets> getAllTweets() {
        return tweetsRepository.findAll();
    }

    @Override
    public void updateLikes(Integer tweetId) {
        Optional<Tweets> foundTweetOptional = tweetsRepository.findById(tweetId);
        if (foundTweetOptional.isPresent()){
            Tweets foundTweet = foundTweetOptional.get();
            int likeCount = foundTweet.getLike_count();
            likeCount = likeCount +1;
            foundTweet.setLike_count(likeCount);
            tweetsRepository.save(foundTweet);
        }else{
            logger.warn("No Tweet found to Delete with Id: {}", tweetId);
        }
    }
    @Override
    public List<Tweets> getUserTweets(String username) {
        Optional<Users> foundUser = userRepository.findByUsername(username);
        if(foundUser.isPresent()){
            Users user = foundUser.get();
            return tweetsRepository.findAllTweetsByUserId(user.getId());
        }else {
            return null;
        }
    }

    @Override
    public Tweets findTweetById(Integer id) {
        Optional<Tweets> foundTweet = tweetsRepository.findById(id);
        return foundTweet.orElse(null);
    }

    @Override
    public void deleteTweet(Integer id) {
        tweetsRepository.deleteById(id);
    }
}
