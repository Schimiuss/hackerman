package com.schimibusiness.hackerman.controllers;

import com.schimibusiness.hackerman.services.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] fileBytes = service.getFileBytes(fileName);
        if (fileBytes == null){
            throw new RuntimeException("The file you are looking for does not exist");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<>(new ByteArrayResource(fileBytes), headers, HttpStatus.OK);
    }
}
