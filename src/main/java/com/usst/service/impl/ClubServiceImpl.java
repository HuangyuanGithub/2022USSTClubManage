package com.usst.service.impl;

import com.usst.dao.ClubDao;
import com.usst.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubDao clubDao;

}
