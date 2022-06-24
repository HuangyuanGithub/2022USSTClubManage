package com.usst.service.impl;


import com.usst.dao.AdminDao;
import com.usst.service.AdminService;
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

}
