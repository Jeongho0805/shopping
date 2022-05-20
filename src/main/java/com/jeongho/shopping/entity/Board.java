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

    //  @JoinColumn(name = "user_id", referencedColumnName = "id") 로 작성해야 하지만, id값이 pk이기 때문에 생략 가능

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
