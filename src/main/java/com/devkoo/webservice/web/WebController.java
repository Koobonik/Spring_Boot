package com.devkoo.webservice.web;

import com.devkoo.webservice.service.AccountService;
import com.devkoo.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class WebController { // 웹컨트롤러로써 GetMapping 이용해서 이곳 저곳 보낼 수 있음 return 값도 잘 이용하자

    private PostsService postsService;
    private AccountService accountService;

    // 메인뷰
    //fineAllDesc 가 오름차순으로 정렬해줄 것임
    @RequestMapping(value="/", method = {RequestMethod.GET, RequestMethod.POST})
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

    @GetMapping("/hello") // 웹에서 /hello 라는 요청이 있을경우
    public String hello() {
        return "hello";
    }
    // 회원가입 페이지
    @RequestMapping(value="signup", method = {RequestMethod.GET, RequestMethod.POST})
    public String signup(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "signup";
    }

    // 로그인 페이지
    @RequestMapping(value="login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "login";
    }

    // 테스트 페이지 : 회원 목록 조회
    @RequestMapping(value="test", method = {RequestMethod.GET, RequestMethod.POST})
    public String test(Model model){
        model.addAttribute("account", accountService.findAllDesc());
        return "test";
    }
}
