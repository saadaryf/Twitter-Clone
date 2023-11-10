package com.appclones.twitterClone.security;

import com.appclones.twitterClone.model.users.MyUserDetails;
import com.appclones.twitterClone.model.users.Users;
import com.appclones.twitterClone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> foundUser = userRepository.findByUsername(username);
        foundUser.orElseThrow(()->new UsernameNotFoundException("Not Found: " + username));
        Users user = foundUser.get();
        return new MyUserDetails(user);
    }
}
