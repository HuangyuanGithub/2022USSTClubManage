package com.usst.service;

import com.usst.entity.ActivityMessage;
import com.usst.utils.Page;

import java.util.List;

public interface ActivityMessageService {

    Page<ActivityMessage> getActivityMessage(Integer activityId, Integer currentPage, Integer pageSize);

    Integer addActivityMessage(ActivityMessage activityMessage);
}
