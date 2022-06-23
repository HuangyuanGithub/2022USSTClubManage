package com.usst.service.impl;

import com.usst.dao.BelongDao;
import com.usst.service.BelongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BelongServiceImpl implements BelongService {
    @Autowired
    private BelongDao belongDao;

}
