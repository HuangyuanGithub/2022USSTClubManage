package com.usst.service;

import com.usst.entity.Belong;
import com.usst.vo.StudentClub;

import java.util.List;

public interface BelongService {

    List<StudentClub> getStudentBelong(Integer id);
    Integer deleteBelong(Belong belong);

    List<StudentClub> getClubBelong(Integer id);

    Integer addBelong(Belong belong);
}
