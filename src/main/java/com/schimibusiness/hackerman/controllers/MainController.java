package com.schimibusiness.hackerman.controllers;

import com.schimibusiness.hackerman.services.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/business")
@RequiredArgsConstructor
public class MainController {

    private final MainService service;
    @GetMapping("/kinda_login")
    public String loginPage(){
        return "login";
    }
    @PostMapping("login_post")
    public String loginGood(){
        return "redirect:home";
    }
    @GetMapping("/home")
    public String showHome(Model model) throws IOException {
        model.addAttribute("name", System.getenv("NAME"));
        model.addAttribute("adr", System.getenv("ADR"));
        model.addAttribute("endpoints", service.getAllEndpoints());
        return "home";
    }

    @GetMapping("/skills")
    public String showSkills(){
        return "skills";
    }

    @GetMapping("/resume")
    public String showResume(){
        return "resume";
    }
}
