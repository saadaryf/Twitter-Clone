package com.appclones.twitterClone.services;

import com.appclones.twitterClone.model.Replies;
import jakarta.transaction.Transactional;

public interface ReplyService {
    @Transactional
    public void saveReply(Replies reply);
}
