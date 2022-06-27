package com.usst.dao;

import com.usst.entity.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityDao {

    //获取全部活动
    @Select("select * from tb_activity where flag = 2 order by date desc")
    List<Activity> getAllActivity();

    @Select("select * from tb_activity where id = #{id}")
    Activity getActivityById(Integer id);


    @Delete("delete form tb_activity where id = #{id}")
    Integer deleActivity(Integer id);




}
