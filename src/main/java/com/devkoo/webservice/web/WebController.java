package com.devkoo.webservice.web;

import com.devkoo.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class WebController { // 웹컨트롤러로써 GetMapping 이용해서 이곳 저곳 보낼 수 있음 return 값도 잘 이용하자

    private PostsService postsService;

    @RequestMapping(value="/", method = {RequestMethod.GET, RequestMethod.POST})
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

    @RequestMapping(value="signup", method = {RequestMethod.GET, RequestMethod.POST})
    public String signup(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "signup";
    }

    @RequestMapping(value="login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "login";
    }

    @RequestMapping(value="home", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "home";
    }

    @RequestMapping(value="hi", method = {RequestMethod.GET, RequestMethod.POST})
    public String hi(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "hi";
    }
}
