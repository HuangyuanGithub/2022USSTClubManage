package com.usst.service.impl;

import com.usst.dao.ClubMessageDao;
import com.usst.entity.Club;
import com.usst.entity.ClubMessage;
import com.usst.service.ClubMessageService;
import com.usst.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubMessageServiceImpl implements ClubMessageService {

    @Autowired
    private ClubMessageDao clubMessageDao;

    @Override
    public Page<ClubMessage> getClubMessage(Integer clubId,Integer currentPage,Integer pageSize) {
        Page<ClubMessage> page = new Page<>();
        page.setTotalCount(clubMessageDao.getClubMessageSum(clubId));
        page.setData(clubMessageDao.getClubMessage(clubId,currentPage,pageSize));
        return page;
    }

    @Override
    public Integer addClubMessage(ClubMessage clubMessage) {
        return clubMessageDao.addClubMessage(clubMessage);
    }
}
