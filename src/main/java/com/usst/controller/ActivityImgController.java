package com.usst.controller;


import com.usst.entity.ActivityImg;
import com.usst.service.ActivityImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("activityImg")
public class ActivityImgController {
    @Autowired
    private ActivityImgService activityImgService;

    @RequestMapping("/{id}")
    public List<ActivityImg> getActivityImg(@PathVariable Integer id) {
        return activityImgService.getActivityImg(id);
    }

    @RequestMapping("/delete/{id}")
    Integer deleteActivityImg(Integer id){
        return activityImgService.deleteActivityImg(id);
    }

    @RequestMapping("/add/{activityId}/{path}")
    Integer addActivityImg(@PathVariable Integer activityId,@PathVariable String path){
        ActivityImg activityImg = new ActivityImg();
        activityImg.setActivityId(activityId);
        activityImg.setPath(path);
        return activityImgService.addActivityImg(activityImg);
    }

}
