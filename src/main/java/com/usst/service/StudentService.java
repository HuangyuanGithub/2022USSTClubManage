package com.usst.service;

import com.usst.entity.Student;

public interface StudentService {
    //登录验证
    Integer studentLogin(String phone,String password);

    //验证注册时用户名是否唯一
    Integer checkPhone(String phone);

    //验证改密码原密码对不对
    Integer checkStudentPassword(Integer studentId,String password);

    //用户注册
    void studentRegister(String phone,String password,String name,String sex);


    //修改密码
    void changePassword(String password,Integer studentId);


    //获取用户信息
    Student getStudentInfo(Integer id);


    //修改用户信息
    void changeStudentInfo(Student student);
}
