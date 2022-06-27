package com.usst.service.impl;

import com.usst.dao.ActivityDao;
import com.usst.entity.Activity;
import com.usst.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Override
    public List<Activity> getAllActivity() {
        return activityDao.getAllActivity();
    }

    @Override
    public Activity getActivityById(Integer id) {
        return activityDao.getActivityById(id);
    }

    @Override
    public Integer deleActivity(Integer id) {
        return activityDao.deleActivity(id);
    }

}
