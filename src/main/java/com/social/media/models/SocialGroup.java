package com.social.media.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SocialGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "groups")
    // 다대다 관계
    // socialUsers의 groups와 매핑
    private Set<SocialUser> socialUsers = new HashSet<>();
}