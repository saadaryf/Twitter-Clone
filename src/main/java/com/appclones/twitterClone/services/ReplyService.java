package com.appclones.twitterClone.services;

import com.appclones.twitterClone.model.Replies;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ReplyService {
    @Transactional
    public void saveReply(Replies reply);

    @Transactional
    public List<Replies> getRepliesOfTweet(Integer tweetId);

    @Transactional
    public List<Replies> getYourOwnReplies(String username);
}
