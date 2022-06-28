package com.usst.dao;

import com.usst.entity.Club;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClubDao {

    @Select("select * from tb_club where flag = 2 order by num desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Club> getAllClub(Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_club where flag = 2")
    Integer getAllClubSum();

    @Select("select * from tb_club where flag = 2 and club_name like CONCAT('%',#{keyWord},'%') limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Club> searchClub(String keyWord,Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_club where flag = 2 and club_name like CONCAT('%',#{keyWord},'%')")
    Integer searchClubSum(String keyWord);

    @Select("select * from tb_club where id = #{id}")
    Club getClubById(Integer id);

    @Delete("delete from tb_club where club_id = #{id}")
    Integer deleteClub(Integer id);



}
