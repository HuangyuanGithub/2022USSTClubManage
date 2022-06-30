package com.usst.dao;

import com.usst.entity.Belong;
import com.usst.entity.Join;
import com.usst.vo.StudentActivity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JoinDao {
    @Select("select activity_id,A.name as activityName,club_name,date from tb_join as J \n" +
            "left join tb_activity as A on J.activity_id = A.id \n" +
            "left join tb_club as C on A.club_id = C.id\n" +
            "where J.student_id = #{id} order by A.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentActivity> getStudentJoin(Integer id,Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_join as J \n" +
            "left join tb_activity as A on J.activity_id = A.id \n" +
            "left join tb_club as C on A.club_id = C.id\n" +
            "where J.student_id = #{id} ")
   Integer getStudentJoinSum(Integer id);



    @Select("select activity_id,A.name as activityName,club_name,date from tb_join as J \n" +
            "left join tb_activity as A on J.activity_id = A.id \n" +
            "left join tb_club as C on A.club_id = C.id\n" +
            "where J.student_id = #{id} and (club_name like CONCAT('%',#{keyWord},'%') or A.name like CONCAT('%',#{keyWord},'%')) \n" +
            " order by A.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentActivity> searchStudentJoin(Integer id,String keyWord,Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_join as J \n" +
            "left join tb_activity as A on J.activity_id = A.id \n" +
            "left join tb_club as C on A.club_id = C.id\n" +
            "where J.student_id = #{id} and (club_name like CONCAT('%',#{keyWord},'%') or A.name like CONCAT('%',#{keyWord},'%'))")
    Integer searchStudentJoinSum(Integer id,String keyWord);





    @Select("select activity_id,J.student_id,name from tb_join as J \n" +
            "left join tb_student as S on J.student_id = S.id \n" +
            "where J.activity_id = #{id} limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentActivity> getActivityJoin(Integer id,Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_join as J left join tb_student as S on J.student_id = S.id \n" +
            "where J.activity_id = #{id}")
    Integer getActivityJoinSum(Integer id);


    @Select("select activity_id,J.student_id,name from tb_join as J \n" +
            "left join tb_student as S on J.student_id = S.id \n" +
            "where J.activity_id = #{id} and name like CONCAT('%',#{keyWord},'%') limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentActivity> searchActivityJoin(Integer id,String keyWord,Integer currentPage,Integer pageSize);


    @Select("select count(*) from tb_join as J \n" +
            "left join tb_student as S on J.student_id = S.id \n" +
            "where J.activity_id = #{id} and name like CONCAT('%',#{keyWord},'%')")
    Integer searchActivityJoinSum(Integer id,String keyWord);


    @Select("select count(*) from tb_join where activity_id = #{activityId} and student_id = #{studentId}")
    Integer isJoin(Integer activityId,Integer studentId);



    @Delete("delete from tb_join where student_id = #{studentId} and activity_id = #{activityId}")
    Integer deleteJoin(Join join);

    @Insert("insert into tb_join (student_id,activity_id) values (#{studentId} , #{activityId})")
    Integer addJoin(Join join);
}
