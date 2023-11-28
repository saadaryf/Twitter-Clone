package com.appclones.twitterClone.mappers;

import com.appclones.twitterClone.model.Messages;
import com.appclones.twitterClone.model.requests.MessageRequest;
import com.appclones.twitterClone.model.responses.MessageResponse;
import com.appclones.twitterClone.model.users.Users;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageMapper {
     public  Messages mapToEntity(MessageRequest messageRequest, Users user, Users receiver){
         Messages message = new Messages();
         message.setMessage_content(messageRequest.getMessage_content());
         Date curtime = new Date();
         message.setMessage_time(curtime);
         message.setSender(user);
         message.setReceiver(receiver);
         return message;
     }

     public MessageResponse mapToDTO(Messages message){
         MessageResponse messageResponse = new MessageResponse();
         messageResponse.setMessage_content(message.getMessage_content());
         messageResponse.setMessage_time(message.getMessage_time());
         messageResponse.setSender(message.getSender());
         return messageResponse;
     }
}
