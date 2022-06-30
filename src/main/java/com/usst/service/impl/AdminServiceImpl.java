package com.usst.service.impl;


import com.usst.dao.AdminDao;
import com.usst.entity.Activity;
import com.usst.entity.Club;
import com.usst.service.AdminService;
import com.usst.utils.Page;
import com.usst.vo.StudentActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public Integer adminLogin(String name,String password) {
        return adminDao.adminLogin(name,password);
    }

    @Override
    public Page<Club> getAllClub(Integer currentPage, Integer pageSize) {
        Page<Club> page=new Page<>();
        page.setTotalCount(adminDao.getAllClubSum());
        page.setData(adminDao.getAllClub(currentPage, pageSize));
        return page;
    }

    @Override
    public Page<StudentActivity> getAllActivity(Integer currentPage, Integer pageSize) {
        Page<StudentActivity> page=new Page<>();
        page.setTotalCount(adminDao.getAllActivitySum());
        page.setData(adminDao.getAllActivity(currentPage, pageSize));
        return page;
    }

    @Override
    public Integer clubPass(Integer id) {
        return adminDao.clubPass(id);
    }

    @Override
    public Integer clubNo(Integer id) {
        return adminDao.clubNo(id);
    }

    @Override
    public Integer activityPass(Integer id) {
        return adminDao.activityPass(id);
    }

    @Override
    public Integer activityNo(Integer id) {
        return adminDao.activityNo(id);
    }

}
