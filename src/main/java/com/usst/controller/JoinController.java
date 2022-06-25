package com.usst.controller;

import com.usst.service.JoinService;
import com.usst.vo.StudentActivity;
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


    @RequestMapping("/student")
    public List<StudentActivity> getStudentJoin(HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("studentId");
        return joinService.getStudentJoin(studentId);
    }

    @RequestMapping("/{id}")
    public List<StudentActivity> getStudentJoin(@PathVariable Integer id) {
        return joinService.getActivityJoin(id);
    }





}
