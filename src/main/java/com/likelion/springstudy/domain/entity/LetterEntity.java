package com.likelion.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name = "Letter")
public class LetterEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,length = 10)
    private String writer;

    @Column(nullable = false,length = 30)
    private  String title;

    @Column(nullable = false,columnDefinition = "TEXT")
    private  String content;

    @Column(nullable = true)
    private  String photo_url;

    @CreationTimestamp
    private LocalDateTime created_at = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "box_id")
    private BoxEntity box;

    @Builder
    public LetterEntity(Long id, String writer, String title, String content, String photo_url, LocalDateTime created_at, BoxEntity box) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.photo_url = photo_url;
        this.created_at = created_at;
        this.box = box;
    }
}
