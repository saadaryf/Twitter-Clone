package com.appclones.twitterClone.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Trends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "trend_name")
    private String trend_name;
}
