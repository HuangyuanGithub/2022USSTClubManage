package com.usst.service;


import com.usst.entity.Club;
import com.usst.utils.Page;
import com.usst.vo.StudentActivity;

import java.util.List;

public interface AdminService {

    Integer adminLogin(String name,String password);

    Page<Club> getAllClub(Integer currentPage, Integer pageSize);

    Page<StudentActivity> getAllActivity(Integer currentPage, Integer pageSize);


    Integer clubPass(Integer id);

    Integer clubNo(Integer id);

    Integer activityPass(Integer id);

    Integer activityNo(Integer id);
}
