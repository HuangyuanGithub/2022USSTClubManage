package com.usst.service.impl;

import com.usst.service.ClubImgService;
import com.usst.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubImgServiceImpl implements ClubImgService {
    @Autowired
    private ClubService clubService;
}
