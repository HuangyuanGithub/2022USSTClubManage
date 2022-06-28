package com.usst.controller;

import com.usst.entity.Club;
import com.usst.service.ClubService;
import com.usst.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Club getClubById(Integer id) {
        return clubService.getClubById(id);
    }

    @RequestMapping("delete/{id}")
    Integer deleteClub(Integer id){
        return clubService.deleteClub(id);
    }

    @RequestMapping("/search/{keyWord}/{currentPage}/{pageSize}")
    public Page<Club> searchClub(@PathVariable String keyWord,@PathVariable Integer currentPage,@PathVariable Integer pageSize) {
        return clubService.searchClub(keyWord,currentPage,pageSize);
    }



}
