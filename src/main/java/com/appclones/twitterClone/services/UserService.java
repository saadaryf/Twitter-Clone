package com.appclones.twitterClone.services;


import com.appclones.twitterClone.model.users.Users;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Set;

public interface UserService {

    @Transactional
    boolean SignUp(Users user);

    Set<String> assignRolesBasedOnBusinessLogic();

    @Transactional
    Users findByUsername(String username);

    @Transactional
    Users findById(Integer id);

    @Transactional
    Users viewProfile(String username);

    @Transactional
    List<Users> getAllUsers();
}
