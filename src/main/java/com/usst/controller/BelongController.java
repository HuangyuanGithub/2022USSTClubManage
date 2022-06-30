package com.usst.controller;

import com.usst.entity.Belong;
import com.usst.service.BelongService;
import com.usst.service.ClubService;
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

    @Autowired
    private ClubService clubService;


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



    @RequestMapping("/club/{id}/{currentPage}/{pageSize}")
    public Page<StudentClub> getClubBelong(@PathVariable Integer id,@PathVariable Integer currentPage,@PathVariable Integer pageSize,HttpSession session) {
        return belongService.getClubBelong(id,currentPage,pageSize);
    }
    @RequestMapping("/searchClub/{id}/{keyWord}/{currentPage}/{pageSize}")
    public Page<StudentClub> getClubBelong(@PathVariable Integer id,@PathVariable String keyWord,@PathVariable Integer currentPage,@PathVariable Integer pageSize,HttpSession session) {
        return belongService.searchClubBelong(id,keyWord,currentPage,pageSize);
    }

    @RequestMapping("/isBelong/{clubId}")
    public Integer isBelong(@PathVariable Integer clubId,HttpSession session){
        Integer id = (Integer) session.getAttribute("studentId");
        Integer flag = belongService.isNowBelong(clubId,id);
        if(flag==1) return 2;
        return belongService.isBelong(clubId,id);
    }




    @RequestMapping("/clubAPP/{id}/{currentPage}/{pageSize}")
    public Page<StudentClub> getClubBelongAPP(@PathVariable Integer id,@PathVariable Integer currentPage,@PathVariable Integer pageSize,HttpSession session) {
        return belongService.getClubBelongAPP(id,currentPage,pageSize);
    }
    @RequestMapping("/searchClubAPP/{id}/{keyWord}/{currentPage}/{pageSize}")
    public Page<StudentClub> getClubBelongAPP(@PathVariable Integer id,@PathVariable String keyWord,@PathVariable Integer currentPage,@PathVariable Integer pageSize,HttpSession session) {
        return belongService.searchClubBelongAPP(id,keyWord,currentPage,pageSize);
    }

    @RequestMapping("/pass/{clubId}/{studentId}")
    public Integer passAPP(@PathVariable Integer clubId, @PathVariable Integer studentId) {
        Belong belong = new Belong();
        belong.setStudentId(studentId);
        belong.setClubId(clubId);
        clubService.clubNum(clubId);
        return belongService.passApp(belong);
    }

    @RequestMapping("/no/{clubId}/{studentId}")
    public Integer noAPP(@PathVariable Integer clubId, @PathVariable Integer studentId) {
        Belong belong = new Belong();
        belong.setStudentId(studentId);
        belong.setClubId(clubId);
        return belongService.noApp(belong);
    }




    @RequestMapping("/add/{clubId}")
    public Integer addBelong(@PathVariable Integer clubId, HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("studentId");
        Belong belong = new Belong();
        belong.setStudentId(studentId);
        belong.setClubId(clubId);
        return belongService.addBelong(belong);
    }


    @RequestMapping("/delete/{clubId}")
    public Integer deleteBelong(@PathVariable Integer clubId, HttpSession session) {
        Integer studentId = (Integer) session.getAttribute("studentId");
        Belong belong = new Belong();
        belong.setStudentId(studentId);
        belong.setClubId(clubId);
        return belongService.deleteBelong(belong);
    }


}
