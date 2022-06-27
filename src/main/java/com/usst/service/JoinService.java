package com.usst.service;

import com.usst.entity.Join;
import com.usst.vo.StudentActivity;

import java.util.List;

public interface JoinService {
    List<StudentActivity> getStudentJoin(Integer id);

    List<StudentActivity> getActivityJoin(Integer id);

    Integer deleteJoin(Join join);

    Integer addJoin(Join join);
}
