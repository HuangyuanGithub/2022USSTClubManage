package com.usst.controller;

import com.usst.entity.ActivityMessage;
import com.usst.entity.ClubMessage;
import com.usst.service.ActivityMessageService;
import com.usst.service.ClubMessageService;
import com.usst.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/activityMessage")
public class ActivityMessageController {

    @Autowired
    private ActivityMessageService activityMessageService;

    @RequestMapping("/{activityId}/{currentPage}/{pageSize}")
    public Page<ActivityMessage> getActivityMessage(@PathVariable Integer activityId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return activityMessageService.getActivityMessage(activityId, currentPage, pageSize);
    }

    @RequestMapping("/add")
    public Integer addActivityMessage(@RequestBody ActivityMessage activityMessage, HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("studentId");
        activityMessage.setStudentId(studentId);
        return activityMessageService.addActivityMessage(activityMessage);
    }



}
