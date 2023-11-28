package com.appclones.twitterClone.services;

import com.appclones.twitterClone.model.Messages;
import com.appclones.twitterClone.model.users.Users;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface MessageService {
    @Transactional
    void saveMessage(Messages message);

    @Transactional
    List<Messages> getAllMessages();

    @Transactional
    List<Messages> findBySenderAndReceiver(Users sender, Users receiver);
}
