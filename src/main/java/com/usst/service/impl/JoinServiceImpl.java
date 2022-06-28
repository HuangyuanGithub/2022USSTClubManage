package com.usst.service.impl;

import com.usst.dao.JoinDao;
import com.usst.entity.Join;
import com.usst.service.JoinService;
import com.usst.utils.Page;
import com.usst.vo.StudentActivity;
import com.usst.vo.StudentClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinServiceImpl implements JoinService {
    @Autowired
    private JoinDao joinDao;

    @Override
    public Page<StudentActivity> getStudentJoin(Integer id,Integer currentPage,Integer pageSize) {
        Page<StudentActivity> page=new Page<>();
        page.setTotalCount(joinDao.getStudentJoinSum(id));
        page.setData(joinDao.getStudentJoin(id,currentPage,pageSize));
        return page;
    }
    @Override
    public Page<StudentActivity> searchStudentJoin(Integer id,String keyWord,Integer currentPage,Integer pageSize){
        Page<StudentActivity> page=new Page<>();
        page.setTotalCount(joinDao.searchStudentJoinSum(id,keyWord));
        page.setData(joinDao.searchStudentJoin(id,keyWord,currentPage,pageSize));
        return page;
    }

    @Override
    public List<StudentActivity> getActivityJoin(Integer id) {
        return joinDao.getActivityJoin(id);
    }

    @Override
    public Integer deleteJoin(Join join) {
        return joinDao.deleteJoin(join);
    }

    @Override
    public Integer addJoin(Join join) {
        return joinDao.addJoin(join);
    }
}
