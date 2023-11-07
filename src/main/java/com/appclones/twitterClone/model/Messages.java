package com.appclones.twitterClone.model;

import com.appclones.twitterClone.model.users.Users;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "message_content")
    private String message_content;

    @Column(name = "message_time")
    private Date message_time;

    /*mapping relations*/

    /*sent messages and user, many to one*/
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Users sender;

    /*received messages and user, many to one*/
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Users receiver;

}
