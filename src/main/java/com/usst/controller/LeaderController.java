package com.usst.controller;

import com.usst.service.LeaderService;
import com.usst.vo.LeaderStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/leader")
public class LeaderController {
    @Autowired
    private LeaderService leaderService;

    @RequestMapping("/club/{id}")
    public List<LeaderStudent> getClubLeader(Integer id) {
        return leaderService.getClubLeader(id);
    }

    @RequestMapping("/student")
    public List<LeaderStudent> getOwnClub(HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("studentId");
        return leaderService.getOwnClub(studentId);
    }



}
