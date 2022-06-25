package com.usst.service.impl;

import com.usst.dao.JoinDao;
import com.usst.service.JoinService;
import com.usst.vo.StudentActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinServiceImpl implements JoinService {
    @Autowired
    private JoinDao joinDao;

    @Override
    public List<StudentActivity> getStudentJoin(Integer id) {
        return joinDao.getStudentJoin(id);
    }

    @Override
    public List<StudentActivity> getActivityJoin(Integer id) {
        return joinDao.getStudentJoin(id);
    }
}
