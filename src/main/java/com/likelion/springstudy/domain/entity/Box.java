package com.likelion.springstudy.domain.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "letter_box")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Box {
    private static final int DEFAULT_LETTER_LIMIT = 20;

    @Id @GeneratedValue(strategy = IDENTITY) // static import로 더 깔끔하게 정리함
    private Long id;

    @Column(nullable = false)
    private String name;

    private int letterLimit;

    @OneToOne(fetch = LAZY) // 연관관계 매핑 - 2.지연로딩
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "box") // 이 소스 코드의 클래스(entity)가 어떤 이름으로 되어 있는지
    private List<Letter> letters = new ArrayList<>();

    @Builder
    public Box(String name, int letterLimit) {
        this.name = name;
        this.letterLimit = letterLimit;
    }
}
