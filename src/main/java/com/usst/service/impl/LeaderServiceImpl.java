package com.usst.service.impl;

import com.usst.dao.LeaderDao;
import com.usst.service.LeaderService;
import com.usst.vo.LeaderStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderServiceImpl implements LeaderService {
    @Autowired
    private LeaderDao leaderDao;

    @Override
    public List<LeaderStudent> getClubLeader(Integer id) {
        return leaderDao.getClubLeader(id);
    }

    @Override
    public List<LeaderStudent> getOwnClub(Integer id) {
        return leaderDao.getOwnClub(id);
    }

    @Override
    public Integer deleteLeader(Integer studentId, Integer clubId) {
        return leaderDao.deleteLeader(studentId,clubId);
    }

    @Override
    public Integer addLeader(Integer studentId, Integer clubId) {
        return leaderDao.addLeader(studentId, clubId);
    }

    @Override
    public Integer isLeader(Integer studentId, Integer clubId) {
        return leaderDao.isLeader(studentId, clubId);
    }
}
