package com.appclones.twitterClone.controllers;

import com.appclones.twitterClone.mappers.MessageMapper;
import com.appclones.twitterClone.mappers.UserMapper;
import com.appclones.twitterClone.model.Messages;
import com.appclones.twitterClone.model.requests.MessageRequest;
import com.appclones.twitterClone.model.responses.MessageResponse;
import com.appclones.twitterClone.model.responses.UserResponse;
import com.appclones.twitterClone.model.users.Users;
import com.appclones.twitterClone.services.MessageService;
import com.appclones.twitterClone.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("message")
public class MessageController {
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;
    @Autowired
    UserMapper userMapper;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "save")
    public String saveMessage(@ModelAttribute MessageRequest messageRequest){
        final Logger logger = LoggerFactory.getLogger(MessageController.class);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Users user = userService.findByUsername(username);
        Users receiver = userService.findById(messageRequest.getReceiverId());
        Messages message = messageMapper.mapToEntity(messageRequest, user,receiver);
        messageService.saveMessage(message);
        return "redirect:/message/view-all?id=" + messageRequest.getReceiverId();
    }
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "view-all")
    public String getAllMessage(@RequestParam("id") Integer id,Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Users user = userService.findByUsername(username);
        UserResponse userResponse = userMapper.mapToDTO(user);

        Users receiver = userService.findById(id);

        List<Messages> sentMessages = messageService.findBySenderAndReceiver(user,receiver);
        List<Messages> receivedMessages = messageService.findBySenderAndReceiver(receiver,user);
        List<Messages> allMessages = new ArrayList<>();
        allMessages.addAll(sentMessages);
        allMessages.addAll(receivedMessages);
        List<Messages> orderedMessages = allMessages.stream()
                .sorted(Comparator.comparing(Messages::getMessage_time))
                .toList();
        List<MessageResponse> messageResponses = orderedMessages.stream()
                .map(messages1 -> messageMapper.mapToDTO(messages1))
                .toList();

        String receiverName = receiver.getName();

        model.addAttribute("messages" , messageResponses);
        model.addAttribute("receiverId", id);
        model.addAttribute("receiverName", receiverName);
        model.addAttribute("user", userResponse);
        return "/chat-box";
    }
}
