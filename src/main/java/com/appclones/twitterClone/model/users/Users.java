package com.appclones.twitterClone.model.users;


import com.appclones.twitterClone.model.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username" ,unique = true)
    private String username;

    @Column(name = "email" , unique = true)
    private String email;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "bio")
    private String bio;

    /* mapping relations */

    /*user and tweets, one to many*/
    @OneToMany(mappedBy = "user")
    private List<Tweets> tweets;

    /*user and replies, one to many*/
    @OneToMany(mappedBy = "user")
    private List<Replies> replies;

    /*student and sent-messages, one to many*/
    @OneToMany(mappedBy = "sender")
    private List<Messages> sentMessages;

    /*student and received-messages, one to many*/
    @OneToMany(mappedBy = "receiver")
    private List<Messages> receivedMessages;

    /*user and notifications, one to many*/
    @OneToMany(mappedBy = "user")
    private List<Notifications> notifications;

    /*user and searchHistory, one to many*/
    @OneToMany(mappedBy = "user")
    private List<SearchHistory> searchHistories;
}
