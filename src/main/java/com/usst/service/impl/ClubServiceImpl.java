package com.usst.service.impl;

import com.usst.dao.ClubDao;
import com.usst.entity.Club;
import com.usst.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubDao clubDao;

    @Override
    public List<Club> getAllClub() {
        return clubDao.getAllClub();
    }

    @Override
    public Club getClubById(Integer id) {
        return clubDao.getClubById(id);
    }
}
