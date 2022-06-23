package com.usst.service.impl;

import com.usst.service.ActivityImgService;
import com.usst.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityImgServiceImpl implements ActivityImgService {
    @Autowired
    private ActivityService activityService;
}
