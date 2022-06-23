package com.usst.controller;

import com.usst.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/club")
public class ClubController {
    @Autowired
    private ClubService clubService;



}
