package com.appclones.twitterClone.services.impl;

import com.appclones.twitterClone.model.Messages;
import com.appclones.twitterClone.model.users.Users;
import com.appclones.twitterClone.repositories.MessageRepository;
import com.appclones.twitterClone.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Override
    public void saveMessage(Messages message) {
        messageRepository.save(message);
    }

    @Override
    public List<Messages> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public List<Messages> findBySenderAndReceiver(Users sender, Users receiver) {
        return messageRepository.findBySenderAndReceiver(sender, receiver);
    }

}
