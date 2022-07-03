package com.usst.controller;

import com.usst.entity.ClubMessage;
import com.usst.service.ClubMessageService;
import com.usst.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/clubMessage")
public class ClubMessageController {

    @Autowired
    private ClubMessageService clubMessageService;

    @RequestMapping("/{clubId}/{currentPage}/{pageSize}")
    public Page<ClubMessage> getClubMessage(@PathVariable Integer clubId,@PathVariable Integer currentPage,@PathVariable Integer pageSize) {
        return clubMessageService.getClubMessage(clubId, currentPage, pageSize);
    }

    @RequestMapping("/add")
    public Integer addClubMessage(@RequestBody ClubMessage clubMessage, HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("studentId");
        clubMessage.setStudentId(studentId);
        return clubMessageService.addClubMessage(clubMessage);
    }


}
