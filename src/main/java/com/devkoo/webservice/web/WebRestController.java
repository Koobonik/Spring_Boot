package com.devkoo.webservice.web;

import com.devkoo.webservice.domain.posts.PostsRepository;
import com.devkoo.webservice.dto.account.AccountSaveRequestDto;
import com.devkoo.webservice.dto.posts.PostsSaveRequestDto;
import com.devkoo.webservice.service.AccountService;
import com.devkoo.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostsRepository postsRepository;
    private PostsService postsService;
    private AccountService accountService;

    @GetMapping("/hello") // 웹에서 /hello 라는 요청이 있을경우
    public String hello() {
        return "HelloWorld hello";
    } // HelloWorld 라는 문구 반환

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Boot";
    } // 조금 더 응용해서 다른 문구도 출력가능하게

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }

    @PostMapping("/account")
    public Long saveAccount(@RequestBody AccountSaveRequestDto dto) {
        return accountService.save(dto);
    }
}

