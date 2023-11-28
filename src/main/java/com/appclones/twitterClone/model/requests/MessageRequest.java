package com.appclones.twitterClone.model.requests;

import com.appclones.twitterClone.model.users.Users;
import lombok.Data;

@Data
public class MessageRequest {
    private int receiverId;
    private String message_content;
}
