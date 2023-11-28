package com.appclones.twitterClone.model.responses;

import com.appclones.twitterClone.model.users.Users;
import lombok.Data;

import java.util.Date;

@Data
public class MessageResponse {
    private Users sender;
    private Date message_time;
    private String message_content;
}
