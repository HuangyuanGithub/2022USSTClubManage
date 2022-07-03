package com.usst.service.impl;

import com.usst.dao.ActivityMessageDao;
import com.usst.entity.ActivityMessage;
import com.usst.service.ActivityMessageService;
import com.usst.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityMessageServiceImpl implements ActivityMessageService {

    @Autowired
    private ActivityMessageDao activityMessageDao;

    @Override
    public Page<ActivityMessage> getActivityMessage(Integer activityId, Integer currentPage, Integer pageSize) {
        Page<ActivityMessage> page = new Page<>();
        page.setTotalCount(activityMessageDao.getActivityMessageSum(activityId));
        page.setData(activityMessageDao.getActivityMessage(activityId,currentPage,pageSize));
        return page;
    }

    @Override
    public Integer addActivityMessage(ActivityMessage activityMessage) {
        return activityMessageDao.addActivityMessage(activityMessage);
    }
}
