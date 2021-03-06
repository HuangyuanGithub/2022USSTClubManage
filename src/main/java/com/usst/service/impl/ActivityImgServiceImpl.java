package com.usst.service.impl;


import com.usst.dao.ActivityImgDao;
import com.usst.entity.ActivityImg;
import com.usst.service.ActivityImgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityImgServiceImpl implements ActivityImgService {

    @Autowired
    private ActivityImgDao activityImgDao;

    @Override
    public List<ActivityImg> getActivityImg(Integer activityId) {
        return activityImgDao.getActivityImg(activityId);
    }

    @Override
    public Integer addActivityImg(ActivityImg activityImg) {
        return activityImgDao.addActivityImg(activityImg);
    }

    @Override
    public Integer deleActivityImg(Integer id) {
        return activityImgDao.deleActivityImg(id);
    }
}
