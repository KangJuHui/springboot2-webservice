package com.spring.book.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ContextConfiguration
//@AutoConfigureMockMvc
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    PostsRepository postRepository;

    @AfterEach
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("kjh@gmail.com")
                .build());

        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
