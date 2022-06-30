package com.usst.service.impl;

import com.usst.dao.ClubDao;
import com.usst.entity.Club;
import com.usst.service.ClubService;
import com.usst.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubDao clubDao;


    @Override
    public Page<Club> getAllClub(Integer currentPage, Integer pageSize) {
        Page<Club> page = new Page<>();
        page.setTotalCount(clubDao.getAllClubSum());
        page.setData(clubDao.getAllClub(currentPage, pageSize));
        return page;
    }


    @Override
    public Club getClubById(Integer id) {
        return clubDao.getClubById(id);
    }

    @Override
    public Integer deleteClub(Integer id) {
        return clubDao.deleteClub(id);
    }

    @Override
    public Page<Club> searchClub(String keyWord, Integer currentPage, Integer pageSize) {
        Page<Club> page = new Page<>();
        page.setTotalCount(clubDao.searchClubSum(keyWord));
        page.setData(clubDao.searchClub(keyWord, currentPage, pageSize));
        return page;
    }

    @Override
    public Integer addClub(Club club) {
        return clubDao.addClub(club);
    }

    @Override
    public Integer clubIntro(String introduction, Integer id) {
        return clubDao.clubIntro(introduction, id);
    }

    @Override
    public Integer clubNum(Integer id) {
        Club club = clubDao.getClubById(id);
        Integer num = club.getNum()+1;
        return clubDao.clubNum(num,id);
    }
}



