package com.appclones.twitterClone.model;

import com.appclones.twitterClone.model.users.Users;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "notification_content")
    private String notification_content;

    @Column(name = "notification_time")
    private Date notification_time;

    /*mapping relations*/

    /*notifications and user, many to one*/
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
