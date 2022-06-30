package com.usst.controller;

import com.usst.entity.Club;
import com.usst.service.ClubService;
import com.usst.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @RequestMapping("/all/{currentPage}/{pageSize}")
    public Page<Club> getAllClub(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return clubService.getAllClub(currentPage,pageSize);
    }
    @RequestMapping("/{id}")
    public Club getClubById(@PathVariable Integer id) {
        return clubService.getClubById(id);
    }

    @RequestMapping("delete/{id}")
    Integer deleteClub(@PathVariable Integer id){
        return clubService.deleteClub(id);
    }

    @RequestMapping("/search/{keyWord}/{currentPage}/{pageSize}")
    public Page<Club> searchClub(@PathVariable String keyWord,@PathVariable Integer currentPage,@PathVariable Integer pageSize) {
        return clubService.searchClub(keyWord,currentPage,pageSize);
    }


    @RequestMapping("/intro/{introduction}/{id}")
    public Integer clubIntro(@PathVariable String introduction,@PathVariable  Integer id) {
        return clubService.clubIntro(introduction, id);
    }




    @PostMapping("/add")
    public Integer addClub(@RequestBody Club club, HttpSession session){
        Integer id = (Integer) session.getAttribute("studentId");
        club.setStudentId(id);
        return clubService.addClub(club);

    }


}
