package com.spring.book.web;

import com.spring.book.service.posts.PostsService;
import com.spring.book.web.dto.PostsListResponseDto;
import com.spring.book.web.dto.PostsResponseDto;
import com.spring.book.web.dto.PostsSaveRequestDto;
import com.spring.book.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);

    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        System.out.println("controller delete 함수 진입");
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }
}
