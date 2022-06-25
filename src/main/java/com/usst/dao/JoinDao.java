package com.usst.dao;

import com.usst.entity.Belong;
import com.usst.entity.Join;
import com.usst.vo.StudentActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JoinDao {
    @Select("select activity_id,J.student_id,A.name,club_name from tb_join as J \n" +
            "left join tb_activity as A on J.activity_id = A.id \n" +
            "left join tb_club as C on A.club_id = C.id\n" +
            "where J.student_id = #{id}")
    List<StudentActivity> getStudentJoin(Integer id);


    @Select("select activity_id,J.student_id,name from tb_join as J \n" +
            "left join tb_student as S on J.student_id = S.id \n" +
            "where J.activity_id = #{id}")
    List<StudentActivity> getActivityJoin(Integer id);
}
