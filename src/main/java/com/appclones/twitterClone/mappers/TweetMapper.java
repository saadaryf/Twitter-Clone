package com.appclones.twitterClone.mappers;

import com.appclones.twitterClone.model.Tweets;
import com.appclones.twitterClone.model.requests.TweetRequest;
import com.appclones.twitterClone.model.responses.TweetResponse;
import com.appclones.twitterClone.model.users.Users;
import com.appclones.twitterClone.services.UserService;
import org.hibernate.annotations.CurrentTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class TweetMapper {
    private static final Logger logger = LoggerFactory.getLogger(TweetMapper.class);

    public Tweets mapToEntity(TweetRequest tweetRequest, Users user){
        Tweets tweet = new Tweets();
        tweet.setContent(tweetRequest.getContent());
        tweet.setTime(new Date());
        tweet.setLike_count(0);

        if (user == null){
            logger.warn("User Not Found in Tweets Mapper");
        }
        tweet.setUser(user);

        return tweet;
    }

    public TweetResponse mapToDTO(Tweets tweet){
            TweetResponse dto = new TweetResponse();
            dto.setId(tweet.getId());
            dto.setName(tweet.getUser().getName());
            dto.setTime(tweet.getTime());
            dto.setLike_count(tweet.getLike_count());
            dto.setContent(tweet.getContent());
            return dto;
    }
}
