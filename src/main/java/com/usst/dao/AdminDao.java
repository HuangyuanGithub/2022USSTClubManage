package com.usst.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface AdminDao {

    //管理员登录
    @Select("select id from tb_admin where name=#{name} and password=#{password}")
    Integer adminLogin(String name,String password);




}
