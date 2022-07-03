package com.usst.dao;

import com.usst.entity.ClubMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClubMessageDao {

    @Select("select message, S.name as studentName from tb_club_message as M left join tb_student as S on student_id = S.id where club_id = #{clubId} " +
            "order by M.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<ClubMessage> getClubMessage(Integer clubId,Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_club_message left join tb_student as S on student_id = S.id where club_id = #{clubId}")
    Integer getClubMessageSum(Integer clubId);


    @Insert("insert into tb_club_message (student_id,message,club_id) values (#{studentId},#{message},#{clubId})")
    Integer addClubMessage(ClubMessage clubMessage);

}
