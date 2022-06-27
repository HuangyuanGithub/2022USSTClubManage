package com.usst.service;

import com.usst.entity.Club;

import java.util.List;

public interface ClubService {
    List<Club> getAllClub();
    Club getClubById(Integer id);

    Integer deleteClub(Integer id);
}
