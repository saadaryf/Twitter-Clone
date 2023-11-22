package com.appclones.twitterClone.services.impl;

import com.appclones.twitterClone.model.Replies;
import com.appclones.twitterClone.repositories.ReplyRepository;
import com.appclones.twitterClone.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyRepository replyRepository;
    @Override
    public void saveReply(Replies reply) {
        replyRepository.save(reply);
    }
}
