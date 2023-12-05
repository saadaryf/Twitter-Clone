package com.appclones.twitterClone.services.impl;

import com.appclones.twitterClone.model.Replies;
import com.appclones.twitterClone.model.users.Users;
import com.appclones.twitterClone.repositories.ReplyRepository;
import com.appclones.twitterClone.repositories.UserRepository;
import com.appclones.twitterClone.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyRepository replyRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void saveReply(Replies reply) {
        replyRepository.save(reply);
    }

    @Override
    public List<Replies> getRepliesOfTweet(Integer tweetId) {
        return replyRepository.findRepliesByTweetId(tweetId);
    }

    @Override
    public List<Replies> getYourOwnReplies(String username) {
        Optional<Users> foundUser = userRepository.findByUsername(username);
        if(foundUser.isPresent()){
            Users user = foundUser.get();
            return replyRepository.findRepliesByUserId(user.getId());
        }else{
            return null;
        }
    }

    @Override
    public void deleteReply(Integer id) {
        replyRepository.deleteById(id);
    }
}
