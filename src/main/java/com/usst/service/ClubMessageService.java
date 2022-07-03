package com.usst.service;


import com.usst.entity.ClubMessage;
import com.usst.utils.Page;

import java.util.List;

public interface ClubMessageService {

    Page<ClubMessage> getClubMessage(Integer clubId,Integer currentPage,Integer pageSize);

    Integer addClubMessage(ClubMessage clubMessage);

}
