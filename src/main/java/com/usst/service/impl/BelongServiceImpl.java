package com.usst.service.impl;

import com.usst.dao.BelongDao;
import com.usst.entity.Belong;
import com.usst.service.BelongService;
import com.usst.vo.StudentClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BelongServiceImpl implements BelongService {
    @Autowired
    private BelongDao belongDao;

    @Override
    public List<StudentClub> getStudentBelong(Integer id) {
        return belongDao.getStudentBelong(id);
    }

    @Override
    public List<StudentClub> getClubBelong(Integer id) {
        return belongDao.getClubBelong(id);
    }

    @Override
    public Integer addBelong(Belong belong) {
        return belongDao.addBelong(belong);
    }

    @Override
    public Integer deleteBelong(Belong belong) {
        return belongDao.deleteBelong(belong);
    }
}
