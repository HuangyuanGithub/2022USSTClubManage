package com.usst.service;

import com.usst.entity.ActivityImg;

import java.util.List;

public interface ActivityImgService {
    List<ActivityImg> getActivityImg(Integer activityId);
    Integer addActivityImg(ActivityImg activityImg);
    Integer deleActivityImg(Integer id);
}
