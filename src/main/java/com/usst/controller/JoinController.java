package com.usst.controller;

import com.usst.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/join")
public class JoinController {
    @Autowired
    private JoinService joinService;



}
