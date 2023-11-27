package com.appclones.twitterClone.model.responses;

import lombok.Data;

@Data
public class UserResponse {
    private Integer id;
    private String name;
    private String username;
    private String email;
}
