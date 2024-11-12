package com.example.test.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {

    private int id;
    private String title;
    private String content;
    private String author;
}
