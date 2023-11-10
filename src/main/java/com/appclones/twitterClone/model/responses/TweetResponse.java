package com.appclones.twitterClone.model.responses;

import lombok.Data;

import java.util.Date;

@Data
public class TweetResponse {
    private int id;
    private String name;
    private Date time;
    private String content;
    private int like_count;
}
