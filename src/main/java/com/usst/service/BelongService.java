package com.usst.service;

import com.usst.entity.Belong;
import com.usst.utils.Page;
import com.usst.vo.StudentClub;

import java.util.List;

public interface BelongService {

    Page<StudentClub> getStudentBelong(Integer id,Integer currentPage,Integer pageSize);


    Page<StudentClub> searchStudentBelong(Integer id,String keyWord,Integer currentPage,Integer pageSize);
    Integer deleteBelong(Belong belong);

    List<StudentClub> getClubBelong(Integer id);

    Integer addBelong(Belong belong);
}
