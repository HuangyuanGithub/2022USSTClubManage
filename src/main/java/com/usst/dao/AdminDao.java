package com.usst.dao;


import com.usst.entity.Club;
import com.usst.vo.StudentActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface AdminDao {

    //管理员登录
    @Select("select count(*) from tb_admin where name=#{name} and password=#{password}")
    Integer adminLogin(String name,String password);


    @Select("select * from tb_club where flag = 0 order by num desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Club> getAllClub(Integer currentPage, Integer pageSize);

    @Select("select count(*) from tb_club where flag = 0")
    Integer getAllClubSum();


    @Select("select A.name as activityName,A.id as activityId,club_name,date from tb_activity as A left join tb_club as C on club_id = C.id \n" +
            "where A.flag = 0 order by A.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentActivity> getAllActivity(Integer currentPage, Integer pageSize);

    @Select("select count(*) from tb_activity where flag = 0")
    Integer getAllActivitySum();


    @Update("update tb_club set flag = 2 where id = #{id}")
    Integer clubPass(Integer id);

    @Update("update tb_club set flag = 1 where id = #{id}")
    Integer clubNo(Integer id);

    @Update("update tb_activity set flag = 2 where id = #{id}")
    Integer activityPass(Integer id);

    @Update("update tb_activity set flag = 1 where id = #{id}")
    Integer activityNo(Integer id);





}
