package com.usst.dao;

import com.usst.entity.ClubImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClubImgDao {

    @Select("select * from tb_club_img where club_id = #{id}")
    List<ClubImg> getClubImg(Integer id);

}
