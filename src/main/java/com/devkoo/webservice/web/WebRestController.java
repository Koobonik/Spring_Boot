package com.devkoo.webservice.web;

import com.devkoo.webservice.domain.posts.Posts;
import com.devkoo.webservice.domain.posts.PostsRepository;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@AllArgsConstructor
public class WebRestController {
    private PostsRepository postsRepository;

    public WebRestController(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }

    @GetMapping("/hello") // 웹에서 /hello 라는 요청이 있을경우
    public String hello() {
        return "HelloWorld";
    } // HelloWorld 라는 문구 반환

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring Boot";
    } // 조금 더 응용해서 다른 문구도 출력가능하게

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}

