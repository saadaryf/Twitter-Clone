package com.appclones.twitterClone.model.requests;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String name;
    private String username;
    private String email;
}
