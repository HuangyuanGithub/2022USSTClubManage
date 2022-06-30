package com.usst.service;

import com.usst.entity.Belong;
import com.usst.utils.Page;
import com.usst.vo.StudentClub;

import java.util.List;

public interface BelongService {

    Page<StudentClub> getStudentBelong(Integer id,Integer currentPage,Integer pageSize);


    Page<StudentClub> searchStudentBelong(Integer id,String keyWord,Integer currentPage,Integer pageSize);

    Page<StudentClub> getClubBelong(Integer id,Integer currentPage,Integer pageSize);


    Page<StudentClub> searchClubBelong(Integer id,String keyWord,Integer currentPage,Integer pageSize);

    Integer isBelong(Integer clubId,Integer studentId);
    Integer isNowBelong(Integer clubId,Integer studentId);

    Integer deleteBelong(Belong belong);



    Integer addBelong(Belong belong);


    Page<StudentClub> getClubBelongAPP(Integer id,Integer currentPage,Integer pageSize);


    Page<StudentClub> searchClubBelongAPP(Integer id,String keyWord,Integer currentPage,Integer pageSize);

    Integer passApp(Belong belong);

    Integer noApp(Belong belong);
}
