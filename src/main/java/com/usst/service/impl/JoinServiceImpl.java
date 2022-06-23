package com.usst.service.impl;

import com.usst.dao.JoinDao;
import com.usst.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceImpl implements JoinService {
    @Autowired
    private JoinDao joinDao;

}
