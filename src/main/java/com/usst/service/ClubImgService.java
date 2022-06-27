package com.usst.service;


import com.usst.entity.ActivityImg;
import com.usst.entity.ClubImg;

import java.util.List;

public interface ClubImgService {
    List<ClubImg> getClubImg(Integer id);

    Integer deleteClubImg(Integer id);

    Integer addClubImg(ClubImg clubImg);
}
