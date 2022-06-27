package com.usst.dao;

import com.usst.entity.Activity;
import com.usst.entity.Club;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClubDao {

    @Select("select * from tb_club where flag = 2")
    List<Club> getAllClub();

    @Select("select * from tb_club where id = #{id}")
    Club getClubById(Integer id);

    @Delete("delete from tb_club where club_id = #{id}")
    Integer deleteClub(Integer id);



}
