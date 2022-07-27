package com.sparta.week01.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    // post에 관한 SQL 역활을 할 아인데 jpa repository의 기능을 내가 가져와서 쓸거다.
    // post라는 녀석이고 Long의 형태를 id를 가졌다.
    List<Post> findAllByOrderByCreatedAtDesc();
}
