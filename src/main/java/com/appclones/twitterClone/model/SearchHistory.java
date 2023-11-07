package com.appclones.twitterClone.model;

import com.appclones.twitterClone.model.users.Users;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "search_content")
    private String search_content;

    /*mapping relations*/

    /*searchHistory and user, many to one*/
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
