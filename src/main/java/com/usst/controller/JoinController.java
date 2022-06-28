package com.usst.controller;

import com.usst.service.JoinService;
import com.usst.utils.Page;
import com.usst.vo.StudentActivity;
import com.usst.vo.StudentClub;
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

    @RequestMapping("/{id}")
    public List<StudentActivity> getActivityJoin(@PathVariable Integer id) {
        return joinService.getActivityJoin(id);
    }





}
