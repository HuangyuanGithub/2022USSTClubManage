package com.usst.dao;

import com.usst.entity.Belong;
import com.usst.vo.StudentClub;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BelongDao {

    @Select("select club_id,B.student_id,club_name,num from tb_belong as B left join tb_club as C\n" +
            "on B.club_id = C.id where B.student_id = #{id} and B.flag = 2 order by num desc\n" +
            "limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentClub> getStudentBelong(Integer id,Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_belong as B left join tb_club as C\n" +
            "on B.club_id = C.id  where B.student_id = #{id} and B.flag = 2")
    Integer getStudentBelongSum(Integer id);

    @Select("select club_id,B.student_id,club_name,num from tb_belong as B left join tb_club as C\n" +
            "on B.club_id = C.id where B.student_id = #{id} and B.flag = 2 and club_name like CONCAT('%',#{keyWord},'%')\n" +
            "order by num desc \n" +
            "limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentClub> searchStudentBelong(Integer id,String keyWord,Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_belong as B left join tb_club as C\n" +
            "on B.club_id = C.id where B.student_id = #{id} and B.flag = 2 and club_name like CONCAT('%',#{keyWord},'%')")
    Integer searchStudentBelongSum(Integer id,String keyWord);


    @Select("select club_id,B.student_id,S.name from tb_belong as B left join tb_student as S\n" +
            "on B.student_id = S.id where B.club_id = #{id} and B.flag = 2 order by S.id\n" +
            "limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentClub> getClubBelong(Integer id,Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_belong as B left join tb_student as S\n" +
            "on B.student_id = S.id where B.club_id = #{id} and B.flag = 2")
    Integer getClubBelongSum(Integer id);

    @Select("select club_id,B.student_id,S.name from tb_belong as B left join tb_student as S\n" +
            "on B.student_id = S.id where B.club_id = #{id} and B.flag = 2 and S.name like CONCAT('%',#{keyWord},'%')\n" +
            "order by S.id \n" +
            "limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentClub> searchClubBelong(Integer id,String keyWord,Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_belong as B left join tb_student as S\n" +
            "on B.student_id = S.id where B.club_id = #{id} and B.flag = 2 and S.name like CONCAT('%',#{keyWord},'%')")
    Integer searchClubBelongSum(Integer id,String keyWord);


    @Select("select count(*) from tb_belong where club_id = #{clubId} and student_id = #{studentId} and flag = 2")
    Integer isBelong(Integer clubId,Integer studentId);

    @Select("select count(*) from tb_belong where club_id = #{clubId} and student_id = #{studentId} and flag = 0")
    Integer isNowBelong(Integer clubId,Integer studentId);


    @Delete("delete from tb_belong where student_id = #{studentId} and club_id = #{clubId}")
    Integer deleteBelong(Belong belong);

    @Insert("insert into tb_belong (student_id,club_id) values (#{studentId} , #{clubId})")
    Integer addBelong(Belong belong);




    @Select("select club_id,B.student_id,S.name from tb_belong as B left join tb_student as S\n" +
            "on B.student_id = S.id where B.club_id = #{id} and B.flag = 0 order by S.id\n" +
            "limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentClub> getClubBelongAPP(Integer id,Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_belong as B left join tb_student as S\n" +
            "on B.student_id = S.id where B.club_id = #{id} and B.flag = 0")
    Integer getClubBelongSumAPP(Integer id);

    @Select("select club_id,B.student_id,S.name from tb_belong as B left join tb_student as S\n" +
            "on B.student_id = S.id where B.club_id = #{id} and B.flag = 0 and S.name like CONCAT('%',#{keyWord},'%')\n" +
            "order by S.id \n" +
            "limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentClub> searchClubBelongAPP(Integer id,String keyWord,Integer currentPage,Integer pageSize);

    @Select("select count(*) from tb_belong as B left join tb_student as S\n" +
            "on B.student_id = S.id where B.club_id = #{id} and B.flag = 0 and S.name like CONCAT('%',#{keyWord},'%')")
    Integer searchClubBelongSumAPP(Integer id,String keyWord);

    @Update("update tb_belong set flag = 2 where student_id = #{studentId} and club_id = #{clubId}")
    Integer passApp(Belong belong);

    @Update("update tb_belong set flag = 1 where student_id = #{studentId} and club_id = #{clubId}")
    Integer noApp(Belong belong);


}
