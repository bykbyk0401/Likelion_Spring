package com.likelion.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "box")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class BoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private  String nickname;

    @OneToOne
    private MemberEntity member;

    @OneToMany(mappedBy = "box")
    private List<LetterEntity> letters = new ArrayList<>();

    @Builder
    public BoxEntity(Long id, String name, String nickname, MemberEntity member, List<LetterEntity> letters) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.member = member;
        this.letters = letters;
    }
}