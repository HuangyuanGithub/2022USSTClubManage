package com.usst.dao;

import com.usst.vo.LeaderStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LeaderDao {

    @Select("select student_id,club_id,name from tb_leader\n" +
            "left join tb_student as S on student_id = S.id\n" +
            "where club_id = #{id}")
    List<LeaderStudent> getClubLeader(Integer id);


    @Select("select student_id,club_id,club_name from tb_leader\n" +
            "left join tb_club as C on club_id = C.id\n" +
            "where student_id = #{id}")
    List<LeaderStudent> getOwnClub(Integer id);



}
