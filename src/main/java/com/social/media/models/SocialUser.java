package com.social.media.models;

import jakarta.persistence.*;

@Entity
// 해당 클래스를 DB의 테이블로 인식
public class SocialUser {
    @Id
    // 해당 변수를 기본키로
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 자동으로 증가되는 값
    private Long id;

    @OneToOne(mappedBy = "user")
    //@JoinColumn(name = "social_profile_id")
    private SocialProfile socialProfile;
}