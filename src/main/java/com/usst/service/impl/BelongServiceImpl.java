package com.usst.service.impl;

import com.usst.dao.BelongDao;
import com.usst.entity.Belong;
import com.usst.entity.Club;
import com.usst.service.BelongService;
import com.usst.utils.Page;
import com.usst.vo.StudentClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BelongServiceImpl implements BelongService {
    @Autowired
    private BelongDao belongDao;

    @Override
    public Page<StudentClub> getStudentBelong(Integer id,Integer currentPage,Integer pageSize) {
        Page<StudentClub> page=new Page<>();
        page.setTotalCount(belongDao.getStudentBelongSum(id));
        page.setData(belongDao.getStudentBelong(id,currentPage,pageSize));
        return page;
    }

    public Page<StudentClub> searchStudentBelong(Integer id,String keyWord,Integer currentPage,Integer pageSize){
        Page<StudentClub> page=new Page<>();
        page.setTotalCount(belongDao.searchStudentBelongSum(id,keyWord));
        page.setData(belongDao.searchStudentBelong(id,keyWord,currentPage,pageSize));
        return page;
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
