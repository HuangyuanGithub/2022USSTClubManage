package com.usst.dao;

import com.usst.entity.Activity;
import com.usst.entity.ActivityMessage;
import com.usst.entity.ClubMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityMessageDao {

    @Select("select message, S.name as studentName from tb_activity_message as M left join tb_student as S on student_id = S.id where activity_id = #{activityId} " +
            "order by M.id desc limit ${(currentPage-1)*pageSize},#{pageSize}")
    List<ActivityMessage> getActivityMessage(Integer activityId, Integer currentPage, Integer pageSize);

    @Select("select * from tb_activity_message left join tb_student as S on student_id = S.id where activity_id = #{activityId}")
    Integer getActivityMessageSum(Integer activityId);


    @Insert("insert into tb_activity_message (student_id,message,activity_id) values (#{studentId},#{message},#{activityId})")
    Integer addActivityMessage(ActivityMessage activityMessage);
}
