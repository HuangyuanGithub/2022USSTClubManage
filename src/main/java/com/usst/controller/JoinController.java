package com.usst.controller;

import com.usst.entity.Activity;
import com.usst.entity.Belong;
import com.usst.entity.Join;
import com.usst.service.ActivityService;
import com.usst.service.BelongService;
import com.usst.service.JoinService;
import com.usst.utils.Page;
import com.usst.vo.StudentActivity;
import com.usst.vo.StudentClub;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/join")
public class JoinController {
    @Autowired
    private JoinService joinService;

    @Autowired
    private BelongService belongService;

    @Autowired
    private ActivityService activityService;



    @RequestMapping("/student/{currentPage}/{pageSize}")
    public Page<StudentActivity> getStudentJoin(@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("studentId");
        return joinService.getStudentJoin(studentId,currentPage,pageSize);
    }

    @RequestMapping("/searchStudent/{keyWord}/{currentPage}/{pageSize}")
    public Page<StudentActivity> getStudentJoin(@PathVariable String keyWord, @PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session) {
        Integer id = (Integer) session.getAttribute("studentId");
        return joinService.searchStudentJoin(id,keyWord,currentPage,pageSize);
    }

    @RequestMapping("/{id}/{currentPage}/{pageSize}")
    public Page<StudentActivity> getActivityJoin(@PathVariable Integer id,@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return joinService.getActivityJoin(id,currentPage,pageSize);
    }

    @RequestMapping("/isJoin/{activityId}")
    public Integer isJoin(@PathVariable Integer activityId,HttpSession session){

        Integer id = (Integer) session.getAttribute("studentId");
        Activity activity = activityService.getActivityById(activityId);
        Integer clubId = activity.getClubId();

        Integer flag = belongService.isBelong(clubId,id);
        if(flag==0) return 0;
        else{
            System.out.println(joinService.isJoin(activityId,id)+1);
            return joinService.isJoin(activityId,id)+1;
        }



    }

    @RequestMapping("/search/{id}/{keyWord}/{currentPage}/{pageSize}")
    public Page<StudentActivity> searchActivityJoin(@PathVariable Integer id,@PathVariable String keyWord,@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return joinService.searchActivityJoin(id,keyWord,currentPage,pageSize);
    }

    @RequestMapping("/add/{activityId}")
    public Integer addJoin(@PathVariable Integer activityId, HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("studentId");
        Join join = new Join();
        join.setStudentId(studentId);
        join.setActivityId(activityId);
        return joinService.addJoin(join);
    }

    @RequestMapping("/delete/{activityId}")
    public Integer deleteJoin(@PathVariable Integer activityId, HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("studentId");
        Join join = new Join();
        join.setStudentId(studentId);
        join.setActivityId(activityId);
        return joinService.deleteJoin(join);
    }





}
