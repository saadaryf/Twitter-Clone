package com.appclones.twitterClone.model.users;


import com.appclones.twitterClone.model.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

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
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Replies> replies;

    /*student and sent-messages, one to many*/
    @OneToMany(mappedBy = "sender")
    private List<Messages> sentMessages;

    /*student and received-messages, one to many*/
    @OneToMany(mappedBy = "receiver")
    private List<Messages> receivedMessages;

    /*creating roles table*/
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles;
}
