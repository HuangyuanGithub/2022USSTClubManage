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

    @Override
    public Page<StudentClub> searchStudentBelong(Integer id,String keyWord,Integer currentPage,Integer pageSize){
        Page<StudentClub> page=new Page<>();
        page.setTotalCount(belongDao.searchStudentBelongSum(id,keyWord));
        page.setData(belongDao.searchStudentBelong(id,keyWord,currentPage,pageSize));
        return page;
    }

    @Override
    public Page<StudentClub> getClubBelong(Integer id,Integer currentPage,Integer pageSize) {
        Page<StudentClub> page=new Page<>();
        page.setTotalCount(belongDao.getClubBelongSum(id));
        page.setData(belongDao.getClubBelong(id,currentPage,pageSize));
        return page;
    }

    @Override
    public Page<StudentClub> searchClubBelong(Integer id,String keyWord,Integer currentPage,Integer pageSize){
        Page<StudentClub> page=new Page<>();
        page.setTotalCount(belongDao.searchClubBelongSum(id,keyWord));
        page.setData(belongDao.searchClubBelong(id,keyWord,currentPage,pageSize));
        return page;
    }

    @Override
    public Integer isBelong(Integer clubId, Integer studentId) {
        return belongDao.isBelong(clubId, studentId);
    }

    @Override
    public Integer isNowBelong(Integer clubId, Integer studentId) {
        return belongDao.isNowBelong(clubId, studentId);
    }


    @Override
    public Integer addBelong(Belong belong) {
        return belongDao.addBelong(belong);
    }

    @Override
    public Page<StudentClub> getClubBelongAPP(Integer id, Integer currentPage, Integer pageSize) {
        Page<StudentClub> page=new Page<>();
        page.setTotalCount(belongDao.getClubBelongSumAPP(id));
        page.setData(belongDao.getClubBelongAPP(id,currentPage,pageSize));
        return page;
    }

    @Override
    public Page<StudentClub> searchClubBelongAPP(Integer id, String keyWord, Integer currentPage, Integer pageSize) {
        Page<StudentClub> page=new Page<>();
        page.setTotalCount(belongDao.searchClubBelongSumAPP(id,keyWord));
        page.setData(belongDao.searchClubBelongAPP(id,keyWord,currentPage,pageSize));
        return page;
    }

    @Override
    public Integer passApp(Belong belong) {
        return belongDao.passApp(belong);
    }

    @Override
    public Integer noApp(Belong belong) {
        return belongDao.noApp(belong);
    }

    @Override
    public Integer deleteBelong(Belong belong) {
        return belongDao.deleteBelong(belong);
    }
}
