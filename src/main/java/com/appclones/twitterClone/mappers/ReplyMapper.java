package com.appclones.twitterClone.mappers;

import com.appclones.twitterClone.model.Replies;
import com.appclones.twitterClone.model.Tweets;
import com.appclones.twitterClone.model.requests.ReplyRequest;
import com.appclones.twitterClone.model.responses.ReplyResponse;
import com.appclones.twitterClone.model.users.Users;
import org.springframework.stereotype.Component;

@Component
public class ReplyMapper {
    public Replies mapToEntity(ReplyRequest replyRequest, Users user, Tweets tweet){
        Replies reply = new Replies();
        reply.setId(replyRequest.getId());
        reply.setReply_content(replyRequest.getContent());
        reply.setTweet(tweet);
        reply.setUser(user);
        return reply;
    }
    public ReplyResponse mapToDTO(Replies reply){
        ReplyResponse dto = new ReplyResponse();
        dto.setName(reply.getUser().getName());
        dto.setContent(reply.getReply_content());
        return dto;
    }
}
