package com.usst.controller;


import com.usst.entity.ActivityImg;
import com.usst.entity.ClubImg;
import com.usst.service.ClubImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clubImg")
public class ClubImgController {
    @Autowired
    private ClubImgService clubImgService;


    @RequestMapping("/{id}")
    public List<ClubImg> getClubImg(@PathVariable Integer id) {
        return clubImgService.getClubImg(id);
    }


    @RequestMapping("/delete/{id}")
    Integer deleteClubImg(Integer id){
        return clubImgService.deleteClubImg(id);
    }

    @RequestMapping("/add/{clubId}/{path}")
    Integer addActivityImg(@PathVariable Integer clubId,@PathVariable String path){
        ClubImg clubImg = new ClubImg();
        clubImg.setClubId(clubId);
        clubImg.setPath(path);
        return clubImgService.addClubImg(clubImg);
    }

}
