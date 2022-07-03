package com.usst.service.impl;

import com.usst.dao.ClubImgDao;
import com.usst.entity.ClubImg;
import com.usst.service.ClubImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubImgServiceImpl implements ClubImgService {

    @Autowired
    private ClubImgDao clubImgDao;

    @Override
    public List<ClubImg> getClubImg(Integer clubId) {
        return clubImgDao.getClubImg(clubId);
    }

    @Override
    public Integer addClubImg(ClubImg clubImg) {
        return clubImgDao.addClubImg(clubImg);
    }

    @Override
    public Integer deleClubImg(Integer id) {
        return clubImgDao.deleClubImg(id);
    }
}
