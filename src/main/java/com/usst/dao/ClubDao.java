package com.usst.dao;

import com.usst.entity.Activity;
import com.usst.entity.Club;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClubDao {

    @Select("select * from tb_club where flag = 2")
    List<Club> getAllClub();

    @Select("select * from tb_club where id = #{id}")
    Club getClubById(Integer id);

}
