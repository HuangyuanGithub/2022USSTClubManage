package com.usst.service.impl;

import com.usst.dao.ActivityDao;
import com.usst.entity.Activity;
import com.usst.entity.Club;
import com.usst.service.ActivityService;
import com.usst.utils.Page;
import com.usst.vo.StudentActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Override
    public Page<StudentActivity> getAllActivity(Integer currentPage, Integer pageSize) {
        Page<StudentActivity> page=new Page<>();
        page.setTotalCount(activityDao.getAllActivitySum());
        page.setData(activityDao.getAllActivity(currentPage, pageSize));
        return page;
    }

    @Override
    public Page<StudentActivity> searchAllActivity(String keyWord, Integer currentPage, Integer pageSize) {
        Page<StudentActivity> page=new Page<>();
        page.setTotalCount(activityDao.searchAllActivitySum(keyWord));
        page.setData(activityDao.searchAllActivity(keyWord,currentPage, pageSize));
        return page;
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
