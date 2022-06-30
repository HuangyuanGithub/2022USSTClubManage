package com.usst.dao;

import com.usst.vo.LeaderStudent;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LeaderDao {

    @Select("select L.student_id,club_id,name from tb_leader as L\n" +
            "left join tb_student as S on student_id = S.id\n" +
            "where club_id = #{id}")
    List<LeaderStudent> getClubLeader(Integer id);


    @Select("select L.student_id,club_id,club_name from tb_leader as L\n" +
            "left join tb_club as C on club_id = C.id\n" +
            "where L.student_id = #{id}")
    List<LeaderStudent> getOwnClub(Integer id);

    @Delete("delete from tb_leader where student_id = #{studentId} and club_id = #{clubId}")
    Integer deleteLeader(Integer studentId,Integer clubId);

    @Insert("insert into tb_leader (student_id,club_id) values (#{studentId},#{clubId})")
    Integer addLeader(Integer studentId,Integer clubId);



}
