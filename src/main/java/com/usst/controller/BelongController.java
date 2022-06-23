package com.usst.controller;

import com.usst.service.BelongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/belong")
public class BelongController {
    @Autowired
    private BelongService belongService;



}
