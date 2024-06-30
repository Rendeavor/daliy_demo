package com.jl.springbootdemo1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DemoController2 {


    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file){

        System.out.println("文件名：" + file.getOriginalFilename());
    }


    @GetMapping("/demo11")
    public String demo1(){
        return "success";
    }
}
