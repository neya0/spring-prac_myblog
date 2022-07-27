package com.sparta.week01.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter // getter를 자동으로 생성해줘라
@Entity // 테이블로 인식해라
@NoArgsConstructor // 기본 생성자를 대신 생성해줘라
public class Post extends Timestamped{

    @Id // 이걸 PK로 쓸거야
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령
    private Long id;

    @Column
    private String title;

    @Column
    private String writer;

    @Column
    private String content;

    @Column
    private String password;

    // requestDto로 정보를 받아 객체를 만들 생성자
    public Post(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }


    // requestDto의 정보를 받는 Setter
    public void update(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}
