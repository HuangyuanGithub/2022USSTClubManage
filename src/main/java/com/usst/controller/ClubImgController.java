package com.usst.controller;


import com.usst.service.ClubImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clubImg")
public class ClubImgController {
    @Autowired
    private ClubImgService clubImgService;
}
