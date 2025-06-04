package com.social.media.models;

import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    // 다대일 관계
    // 여러 게시물을 한명의 유저가 가지고 있을 수 있음
    // user_id를 외래키로 지정
    @JoinColumn(name = "user_id")
    private SocialUser socialUser;
}