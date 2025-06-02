package com.social.media.models;

import jakarta.persistence.*;

@Entity
//엔티티를 정의
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "social_user")
    private SocialUser user;
}