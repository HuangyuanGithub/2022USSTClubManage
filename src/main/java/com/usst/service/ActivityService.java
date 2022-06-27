package com.usst.service;

import com.usst.entity.Activity;

import java.util.List;

public interface ActivityService {
    List<Activity> getAllActivity();

    Activity getActivityById(Integer id);

    Integer deleActivity(Integer id);
}
