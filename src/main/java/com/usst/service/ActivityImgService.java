package com.usst.service;


import com.usst.entity.ActivityImg;

import java.util.List;

public interface ActivityImgService {

    List<ActivityImg> getActivityImg(Integer id);

    Integer deleteActivityImg(Integer id);

    Integer addActivityImg(ActivityImg activityImg);
}
