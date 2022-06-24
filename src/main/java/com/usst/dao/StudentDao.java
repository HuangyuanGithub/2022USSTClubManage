package com.usst.dao;

import com.usst.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentDao {

    //登录验证
    @Select("select id from tb_student where phone=#{phone} and password=#{password}")
    Integer studentLogin(String phone,String password);


    //验证注册时用户名唯一
    @Select("select count(*) from tb_student where phone=#{phone}")
    Integer checkPhone(String phone);


    //用户注册
    @Insert("insert into tb_student(phone,password,name,sex) values (#{phone},#{password},#{name},#{sex})")
    void studentRegister(String phone,String password,String name,String sex);


    //用户修改密码
    @Update("update tb_student set password = #{password} where id = #{id}")
    void changePassword(String password,Integer id);


    //获取用户信息
    @Select("select * from tb_student where id = #{id}")
    Student getStudentInfo(Integer id);


    //用户修改信息
    @Update("update tb_student set phone =#{phone},introduction=#{introduction},grade=#{grade},major=#{major} where id =#{id}")
    void changeStudentInfo(Student student);
}
