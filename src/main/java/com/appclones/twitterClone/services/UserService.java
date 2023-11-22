package com.appclones.twitterClone.services;


import com.appclones.twitterClone.model.users.Users;
import jakarta.transaction.Transactional;

import java.util.Set;

public interface UserService {

    @Transactional
    boolean SignUp(Users user);

    Set<String> assignRolesBasedOnBusinessLogic();

    @Transactional
    Users findByUsername(String username);

    @Transactional
    Users viewProfile(String username);
}
