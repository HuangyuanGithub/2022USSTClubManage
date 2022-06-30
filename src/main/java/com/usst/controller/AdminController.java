package com.usst.controller;

import com.usst.entity.Admin;
import com.usst.entity.Club;
import com.usst.service.AdminService;
import com.usst.service.ClubService;
import com.usst.service.LeaderService;
import com.usst.utils.Page;
import com.usst.vo.StudentActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ClubService clubService;

    @Autowired
    private LeaderService leaderService;

    @RequestMapping("/login")
    public Integer userLogin(@RequestBody Admin admin, HttpSession session){
        Integer id = adminService.adminLogin(admin.getName(),admin.getPassword());
        if(id!=null) session.setAttribute("adminId",id);
        return id;
    }

    @RequestMapping("/club/{currentPage}/{pageSize}")
    public Page<Club> getAllClub(@PathVariable Integer currentPage,@PathVariable Integer pageSize, HttpSession session) {
        Integer id = (Integer) session.getAttribute("adminId");
        if(id==null) return null;
        return adminService.getAllClub(currentPage, pageSize);
    }

    @RequestMapping("/activity/{currentPage}/{pageSize}")
    public Page<StudentActivity> getAllActivity(@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session) {
        Integer id = (Integer) session.getAttribute("adminId");
        if(id==null) return null;
        return adminService.getAllActivity(currentPage, pageSize);
    }



    @RequestMapping("/clubPass/{id}")
    public Integer clubPass(@PathVariable Integer id){
        Club club = clubService.getClubById(id);
        Integer studentId = club.getStudentId();
        leaderService.addLeader(studentId,id);
        return adminService.clubPass(id);
    }

    @RequestMapping("/clubNo/{id}")
    public Integer clubNo(@PathVariable Integer id){
        return adminService.clubNo(id);
    }


    @RequestMapping("/activityPass/{id}")
    public Integer activityPass(@PathVariable Integer id){
        return adminService.activityPass(id);
    }

    @RequestMapping("/activityNo/{id}")
    public Integer activityNo(@PathVariable Integer id){
        return adminService.activityNo(id);
    }
}
