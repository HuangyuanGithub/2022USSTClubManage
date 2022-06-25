package com.usst.controller;

import com.usst.entity.Club;
import com.usst.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @RequestMapping("/all")
    public List<Club> getAllClub() {
        return clubService.getAllClub();
    }
    @RequestMapping("/{id}")
    public Club getClubById(Integer id) {
        return clubService.getClubById(id);
    }




}
