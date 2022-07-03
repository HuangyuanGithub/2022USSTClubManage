package com.usst.service;


import com.usst.entity.ClubImg;

import java.util.List;

public interface ClubImgService {

    List<ClubImg> getClubImg(Integer clubId);

    Integer addClubImg(ClubImg clubImg);

    Integer deleClubImg(Integer id);


}
