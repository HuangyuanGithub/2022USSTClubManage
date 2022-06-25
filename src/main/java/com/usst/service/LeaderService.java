package com.usst.service;

import com.usst.vo.LeaderStudent;

import java.util.List;

public interface LeaderService {
    List<LeaderStudent> getClubLeader(Integer id);
    List<LeaderStudent> getOwnClub(Integer id);
}
