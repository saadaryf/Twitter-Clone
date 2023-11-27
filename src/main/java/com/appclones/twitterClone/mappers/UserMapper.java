package com.appclones.twitterClone.mappers;

import com.appclones.twitterClone.model.requests.UserRequest;
import com.appclones.twitterClone.model.responses.UserResponse;
import com.appclones.twitterClone.model.users.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);
    public Users mapToEntity(UserRequest userRequest){
        Users user=new Users();
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return user;
    }
    public UserResponse mapToDTO(Users user){
        UserResponse userResponse= new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setId(user.getId());
        return userResponse;
    }



}
