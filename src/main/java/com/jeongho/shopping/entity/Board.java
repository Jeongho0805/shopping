package com.jeongho.shopping.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String name;

    private String views;


}
