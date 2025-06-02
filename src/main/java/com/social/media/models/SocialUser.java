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

    // SocialProfile 엔티티의 user 필드에 의해 매핑된 양방향 OneToOne 관계의 주인이 아님을 의미
    @OneToOne(mappedBy = "user")
    //@JoinColumn(name = "social_profile_id")
    // 관계의 주인이 아니므로 외래키 설정을 직접 하지 않음 (주인은 SocialProfile임)
    private SocialProfile socialProfile;
}