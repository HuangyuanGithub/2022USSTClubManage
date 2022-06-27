package com.usst.dao;

import com.usst.entity.Belong;
import com.usst.vo.StudentClub;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BelongDao {

    @Select("select club_id,B.student_id,club_name from tb_belong as B left join tb_club as C\n" +
            "on B.club_id = C.id where B.student_id = #{id}")
    List<StudentClub> getStudentBelong(Integer id);


    @Select("select club_id,B.student_id,S.name from tb_belong as B left join tb_student as S\n" +
            "on B.student_id = S.id where B.club_id = #{id}")
    List<StudentClub> getClubBelong(Integer id);

    @Delete("delete from tb_belong where student_id = #{studentId} and club_id = #{clubId}")
    Integer deleteBelong(Belong belong);

    @Insert("insert into tb_belong (student_id,club_id) values (#{studentId} , #{clubId})")
    Integer addBelong(Belong belong);
}
