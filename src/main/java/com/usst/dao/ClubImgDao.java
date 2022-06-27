package com.usst.dao;

import com.usst.entity.ClubImg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClubImgDao {

    @Select("select * from tb_club_img where club_id = #{id}")
    List<ClubImg> getClubImg(Integer id);


    @Delete("delete from tb_club_img where id = #{id}")
    Integer deleteClubImg(Integer id);

    @Insert("insert into tb_club_img (club_id,path) values (#{clubId},#{path})")
    Integer addClubImg(ClubImg clubImg);

}
