package com.appclones.twitterClone.model;

import com.appclones.twitterClone.model.users.Users;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Tweets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content", length = 5000)
    private String content;

    @Column(name = "time")
    private Date time;

    @Column(name = "like_count")
    private int like_count;

    /*mapping relations*/

    /*tweets and user, many to one */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    /*tweet and replies, one to many*/
    @OneToMany(mappedBy = "tweet")
    private List<Replies> replies;


}
