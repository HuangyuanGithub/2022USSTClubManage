package com.usst.controller;

import com.usst.entity.Belong;
import com.usst.service.BelongService;
import com.usst.utils.Page;
import com.usst.vo.StudentClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/belong")
public class BelongController {
    @Autowired
    private BelongService belongService;


    @RequestMapping("/student/{currentPage}/{pageSize}")
    public Page<StudentClub> getStudentBelong(@PathVariable Integer currentPage,@PathVariable Integer pageSize,HttpSession session) {
        Integer id = (Integer) session.getAttribute("studentId");
        return belongService.getStudentBelong(id,currentPage,pageSize);
    }
    @RequestMapping("/searchStudent/{keyWord}/{currentPage}/{pageSize}")
    public Page<StudentClub> getStudentBelong(@PathVariable String keyWord,@PathVariable Integer currentPage,@PathVariable Integer pageSize,HttpSession session) {
        Integer id = (Integer) session.getAttribute("studentId");
        return belongService.searchStudentBelong(id,keyWord,currentPage,pageSize);
    }



    @RequestMapping("/club")
    public List<StudentClub> getClubBelong(Integer id) {
        return belongService.getClubBelong(id);
    }


    @RequestMapping("/add/{clubId}/{studentId}")
    public Integer addBelong(@PathVariable Integer clubId, HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("studentId");
        Belong belong = new Belong();
        belong.setStudentId(studentId);
        belong.setClubId(clubId);
        return belongService.addBelong(belong);
    }


    @RequestMapping("/delete/{clubId}/{studentId}")
    public Integer deleteBelong(@PathVariable Integer clubId, HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("studentId");
        Belong belong = new Belong();
        belong.setStudentId(studentId);
        belong.setClubId(clubId);
        return belongService.deleteBelong(belong);
    }


}
