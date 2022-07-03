package com.usst.dao;

import com.usst.entity.ActivityImg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityImgDao {

    @Select("select * from tb_activity_img where activity_id = #{activityId}")
    List<ActivityImg> getActivityImg(Integer activityId);

    @Insert("insert into tb_activity_img (activity_id,path) values(#{activityId},#{path})")
    Integer addActivityImg(ActivityImg activityImg);

    @Delete("delete from tb_activity_img where id = #{id}")
    Integer deleActivityImg(Integer id);

}
