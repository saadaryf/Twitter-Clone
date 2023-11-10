package com.appclones.twitterClone.mappers;

import com.appclones.twitterClone.model.requests.UserRequest;
import com.appclones.twitterClone.model.users.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public Users mapToEntity(UserRequest userRequest){
        Users user=new Users();
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return user;
    }



}
