package com.social.media.models;

import jakarta.persistence.*;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
// 해당 클래스를 DB의 테이블로 인식
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "socialUser")
    // Post의 socialUser와 매핑
    private List<Post> posts = new ArrayList<>();


    @ManyToMany
    // 다대다 관계
    //
    @JoinTable(
            name = "user_group", // 중간테이블 이름
            joinColumns = @JoinColumn(name = "user_id"), // 현재 엔티티의 왜래키 이름
            inverseJoinColumns = @JoinColumn(name = "group_id") // 반대 엔티티의 외래키 이름
    )
    // SocialGroup을 set으로 groups라는 이름으로 생성
    // 같은 그룹에 중복이 되어서 포함이 되지 않도록 set을 이용
    private Set<SocialGroup> groups = new HashSet<>();

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }


//    관계 유형	사용 방식
//    @ManyToOne, @OneToOne	@JoinColumn으로 외래 키 직접 설정
//    @ManyToMany	@JoinTable + @JoinColumn 2개 필요 (중간 테이블 구성)
}