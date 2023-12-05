package com.appclones.twitterClone.mappers;

import com.appclones.twitterClone.model.requests.UserUpdateRequest;
import com.appclones.twitterClone.model.users.Users;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateMapper {
    public Users mapToEntity(UserUpdateRequest userUpdateRequest){
        Users user2 = new Users();
        user2.setName(userUpdateRequest.getName());
        user2.setUsername(userUpdateRequest.getUsername());
        user2.setEmail(userUpdateRequest.getEmail());
        return user2;
    }
}
