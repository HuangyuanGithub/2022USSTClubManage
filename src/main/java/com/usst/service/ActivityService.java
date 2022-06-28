package com.usst.service;

import com.usst.entity.Activity;
import com.usst.utils.Page;
import com.usst.vo.StudentActivity;

import java.util.List;

public interface ActivityService {
    Page<StudentActivity> getAllActivity(Integer currentPage, Integer pageSize);
    Page<StudentActivity> searchAllActivity(String keyWord ,Integer currentPage, Integer pageSize);

    Activity getActivityById(Integer id);

    Integer deleActivity(Integer id);
}
