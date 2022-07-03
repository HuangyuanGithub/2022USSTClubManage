package com.usst.dao;

import com.usst.entity.Activity;
import com.usst.entity.Club;
import com.usst.vo.StudentActivity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ActivityDao {

    //获取全部活动
    @Select("select A.name as activityName,A.id as activityId,club_name,date from tb_activity as A left join tb_club as C on club_id = C.id \n" +
            "where A.flag = 2 order by A.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentActivity> getAllActivity(Integer currentPage, Integer pageSize);

    @Select("select count(*) from tb_activity where flag = 2")
    Integer getAllActivitySum();

    @Select("select A.name as activityName,A.id as activityId,club_name,date from tb_activity as A left join tb_club as C on club_id = C.id \n" +
            "where A.flag = 2 and (club_name like CONCAT('%',#{keyWord},'%') or name like CONCAT('%',#{keyWord},'%'))\n" +
            "order by A.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<StudentActivity> searchAllActivity(String keyWord ,Integer currentPage, Integer pageSize);

    @Select("select count(*) from tb_activity as A left join tb_club as C on club_id = C.id \n" +
            "where A.flag = 2 and (club_name like CONCAT('%',#{keyWord},'%') or name like CONCAT('%',#{keyWord},'%'))")
    Integer searchAllActivitySum(String keyWord);



    @Select("select * from tb_activity as A left join tb_club as C on club_id = C.id \n" +
            "where A.flag = 2 and club_id = #{id} order by A.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Activity> getClubActivity(Integer id,Integer currentPage, Integer pageSize);


    @Select("select count(*) from tb_activity where club_id = #{id} and flag = 2")
    Integer getClubActivitySum(Integer id);


    @Select("select * from tb_activity as A left join tb_club as C on club_id = C.id \n" +
            "where A.flag = 2 and A.club_id = #{id} and (A.name like CONCAT('%',#{keyWord},'%') or date like CONCAT('%',#{keyWord},'%'))" +
            "order by A.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<Activity> searchClubActivity(Integer id,String keyWord,Integer currentPage, Integer pageSize);

    @Select("select count(*) from tb_activity as A left join tb_club as C on club_id = C.id \n" +
            "where A.flag = 2 and A.club_id = #{id} and (A.name like CONCAT('%',#{keyWord},'%') or date like CONCAT('%',#{keyWord},'%'))")
    Integer searchClubActivitySum(Integer id,String keyWord);


    @Select("select * from tb_activity where id = #{id}")
    Activity getActivityById(Integer id);


    @Delete("delete from tb_activity where id = #{id}")
    Integer deleActivity(Integer id);

    @Insert("insert into tb_activity (name,introduction,date,club_id) values (#{name},#{introduction},#{date},#{clubId})")
    Integer addActivity(Activity activity);


    @Update("update tb_activity set introduction = #{introduction} ,date = #{date} where id = #{id}")
    Integer updateActivity(Activity activity);




}
