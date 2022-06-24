package com.usst.controller;

import com.usst.entity.Admin;
import com.usst.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public Integer userLogin(@RequestBody Admin admin, HttpSession session){
        Integer id = adminService.adminLogin(admin.getName(),admin.getPassword());
        if(id!=null) session.setAttribute("adminId",id);
        return id;
    }

}
