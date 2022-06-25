package com.usst.dao;

import com.usst.entity.ActivityImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityImgDao {

    @Select("select * from tb_activity_img where activity_id = #{id}")
    List<ActivityImg> getActivityImg(Integer id);




}
