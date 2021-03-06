package com.usst.service;

import com.usst.entity.Club;
import com.usst.utils.Page;

import java.util.List;

public interface ClubService {
    Page<Club> getAllClub(Integer currentPage, Integer pageSize);

    Club getClubById(Integer id);

    Integer deleteClub(Integer id);


    Page<Club> searchClub(String keyWord,Integer currentPage,Integer pageSize);

    Integer addClub(Club club);

    Integer clubIntro(String introduction,Integer id);

    Integer clubNum(Integer id);

    public Integer clubNumDesc(Integer id);
}
