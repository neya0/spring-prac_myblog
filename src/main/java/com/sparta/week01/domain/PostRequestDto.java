package com.sparta.week01.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PostRequestDto {
    private final String title;
    private final String writer;
    private final String content;
    private final String password;

}
