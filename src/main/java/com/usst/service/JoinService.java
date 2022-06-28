package com.usst.service;

import com.usst.entity.Join;
import com.usst.utils.Page;
import com.usst.vo.StudentActivity;

import java.util.List;

public interface JoinService {
    Page<StudentActivity> getStudentJoin(Integer id,Integer currentPage,Integer pageSize);

    Page<StudentActivity> searchStudentJoin(Integer id,String keyWord,Integer currentPage,Integer pageSize);

    List<StudentActivity> getActivityJoin(Integer id);

    Integer deleteJoin(Join join);

    Integer addJoin(Join join);
}
