package com.social.media.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
//엔티티를 정의
//SocialProfile은 DB의 테이블
//@Entity 해당 어노테이션 덕분에 아래 클래스를 테이블로 인식
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {
    @Id
    // @Id는 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 자동 증가하는 정수 값
    private Long id;

    @OneToOne
    // SocialProfile과 SocialUser 간에 1:1 관계임을 의미합니다.
    // 예: 하나의 유저는 하나의 프로필을 가진다.
    @JoinColumn(name = "social_user")
    @JsonIgnore
    // 양방향 연관관계(@OneToOne, @ManyToOne 등)에서 순환 참조가 발생할  @JsonIgnore을 사용해서 무한루프를 방지
    // 이 테이블(social_profile)에 social_user라는 외래키(FK) 컬럼을 만들어 SocialUser 엔티티의 id와 연결합니다.
    // 참조하는 엔티티 (SocialUser)의 기본키(@Id) 에 자동으로 연결한다.
    private SocialUser user;

    private String description;

    public void setSocialUser(SocialUser socialUser){
        // 여기서 this는 해당 setSocialUser을 호출한 객체
        this.user = socialUser;
        if (user.getSocialProfile() != this)
            user.setSocialProfile(this);
    }

}