package com.devkoo.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    @GetMapping("/hello") // 웹에서 /hello 라는 요청이 있을경우
    public String hello() {
        return "HelloWorld";
    } // HelloWorld 라는 문구 반환

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring Boot";
    } // 조금 더 응용해서 다른 문구도 출력가능하게
}