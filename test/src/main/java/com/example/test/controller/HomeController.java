package com.example.test.controller;

import com.example.test.dto.BoardDTO;
import com.example.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String index(){
        System.out.println("11");
        return "index";
    }

    @GetMapping("/re1")
    public String re1(BoardDTO dto){
        log.info(String.valueOf(dto));
        return "re1";
    }

    @GetMapping("/exUpload")
    public void exUpload(){
        log.info("exUpload.........");
    }

    @PostMapping("upload")
    public void exUploadPost( @RequestParam("file") MultipartFile file){
        log.info(file.getOriginalFilename());
        log.info(String.valueOf(file.getSize()));
        log.info(file.getContentType());
    }


    @PostMapping("/register")
    public String registerUser(Model model){
        String generatedNickname = userService.generateRandomNickname(); // 랜덤 닉네임 생성
        userService.saveUser(generatedNickname); // 생성된 닉네임 DB에 저장
        model.addAttribute("message", "회원가입이 완료되었습니다. 닉네임: " + generatedNickname);
        return "registrationSuccess"; // 회원가입 성공 페이지
    }


}
