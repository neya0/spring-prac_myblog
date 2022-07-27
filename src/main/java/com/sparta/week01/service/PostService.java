package com.sparta.week01.service;

import com.sparta.week01.domain.Post;
import com.sparta.week01.domain.PostRepository;
import com.sparta.week01.domain.PostRequestDto;
import com.sparta.week01.domain.PostResponseDto;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post findPost(Long id){
        return postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시물을 찾을 수 없습니다.")
        );
    }

    public List<PostResponseDto> getPostList(){
        List<Post> list = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostResponseDto> postList = new ArrayList<>();
        for(Post post : list){
            postList.add(new PostResponseDto(post));
        }
        return postList;
    }

    @Transactional
    public PostResponseDto editPost(Long id, PostRequestDto requestDto){
        Post post = findPost(id);
        post.update(requestDto);
        return new PostResponseDto(post);
    }
}
