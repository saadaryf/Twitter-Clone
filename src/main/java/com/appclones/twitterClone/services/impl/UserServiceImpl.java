package com.appclones.twitterClone.services.impl;

import com.appclones.twitterClone.model.users.Users;
import com.appclones.twitterClone.repositories.UserRepository;
import com.appclones.twitterClone.services.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean SignUp(Users user) {
        Optional<Users> foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser.isPresent()) {
            logger.info("User already present");
            return false;
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<String> roles = assignRolesBasedOnBusinessLogic();
            user.setRoles(roles);
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public Set<String> assignRolesBasedOnBusinessLogic() {
        // Implement your role assignment logic based on student properties
        Set<String> roles = new HashSet<>();
        // Example: Assign ROLE_USER to all students
        roles.add("ROLE_USER");
        return roles;
    }

    @Override
    public Users findByUsername(String username) {
        Optional<Users> foundUser = userRepository.findByUsername(username);
        return foundUser.orElse(null);
    }


}
