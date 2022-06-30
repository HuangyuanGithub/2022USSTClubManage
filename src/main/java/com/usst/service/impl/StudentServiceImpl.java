package com.usst.service.impl;

import com.usst.dao.StudentDao;
import com.usst.entity.Student;
import com.usst.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Integer checkStudentPassword(Integer studentId,String password) {
        Student student = studentDao.getStudentInfo(studentId);
        if(student.getPassword().equals(password)) return 1;
        else return 0;
    }

    //用户登录
    @Override
    public Integer studentLogin(String phone,String password) {
        return studentDao.studentLogin(phone,password);
    }

    //验证注册时用户名是否唯一
    @Override
    public Integer checkPhone(String phone) {
        return studentDao.checkPhone(phone);
    }

    //用户注册
    @Override
    public void studentRegister(String phone, String password, String name) {
        studentDao.studentRegister(phone,password,name);
    }

    //密码修改
    @Override
    public Integer changePassword(String password, Integer studentId) {
        return studentDao.changePassword(password,studentId);
    }



    //获取用户信息
    @Override
    public Student getStudentInfo(Integer id) {
        return studentDao.getStudentInfo(id);
    }

    //修改用户信息
    @Override
    public void changeStudentInfo(Student student) {
        studentDao.changeStudentInfo(student);
    }


}
