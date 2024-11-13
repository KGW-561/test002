package com.example.test.controller;

import com.example.test.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
}
