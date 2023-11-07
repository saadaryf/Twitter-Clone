package com.appclones.twitterClone.model;

import com.appclones.twitterClone.model.users.Users;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Replies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "reply_content")
    private String reply_content;

    /*mapping relations*/

    /*replies and user, many to one*/
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    /*replies and tweets, many to one*/
    @ManyToOne
    @JoinColumn(name = "tweet_id")
    private Tweets tweet;
}
