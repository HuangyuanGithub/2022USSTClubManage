package com.usst.controller;

import com.usst.entity.Activity;
import com.usst.service.ActivityService;
import com.usst.utils.Page;
import com.usst.vo.StudentActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("/all/{currentPage}/{pageSize}")
    public Page<StudentActivity> getAllActivity(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        return activityService.getAllActivity(currentPage, pageSize);
    }
    @RequestMapping("/search/{keyWord}/{currentPage}/{pageSize}")
    public Page<StudentActivity> getAllActivity(@PathVariable String keyWord,@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        return activityService.searchAllActivity(keyWord,currentPage, pageSize);
    }


    @RequestMapping("/{id}")
    public Activity getActivityById(@PathVariable Integer id) {
        return activityService.getActivityById(id);
    }

    @RequestMapping("/delete/{id}")
    public Integer deleActivity(@PathVariable Integer id) {
        return activityService.deleActivity(id);
    }


}
