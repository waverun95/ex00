package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Controller
@RequestMapping("sample/*")
@Log4j
public class SampleController {
    @GetMapping("/exUpload")
    public void exUpload(){
        log.info("/exUpload../...");
    }
   @PostMapping("exUploadPost")
    public void ex(ArrayList<MultipartFile> files){

        files.forEach(file -> {
            log.info("---------");
            log.info("name" + file.getOriginalFilename());
            log.info("size" + file.getSize());
        });
   }
}
