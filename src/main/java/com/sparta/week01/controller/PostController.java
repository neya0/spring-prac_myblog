package com.sparta.week01.controller;

import com.sparta.week01.domain.Post;
import com.sparta.week01.domain.PostRepository;
import com.sparta.week01.domain.PostRequestDto;
import com.sparta.week01.domain.PostResponseDto;
import com.sparta.week01.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    // 게시글 작성 API
    @PostMapping("/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto){
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    // 게시글 전체 조회 API
    @GetMapping("/posts")
    public List<PostResponseDto> getPostList(){
        return postService.getPostList();
    }

    // 게시글 조회 API
    @GetMapping("/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id){
        return new PostResponseDto(postService.findPost(id));
    }

    // 비밀번호 확인 API
    @PostMapping("/posts/{id}")
    public Boolean checkPassword(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        Post post = postService.findPost(id);
        return post.getPassword().equals(requestDto.getPassword());
    }

    // 게시글 수정 API
    @PutMapping("/posts/{id}")
    public PostResponseDto editPost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.editPost(id, requestDto);
    }

    // 게시글 삭제 API
    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return "삭제 완료";
    }
}
