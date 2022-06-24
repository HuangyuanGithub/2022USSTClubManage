package com.usst.controller;

import com.usst.entity.Student;
import com.usst.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    //用户登录
    @RequestMapping("/login")
    public Integer studentLogin(@RequestBody Student student, HttpSession session){
        Integer studentId = studentService.studentLogin(student.getPhone(),student.getPassword());
        if(studentId!=null) session.setAttribute("studentId",studentId);
        return studentId;
    }

    //验证注册时用户名是否唯一
    @RequestMapping("/checkStudent/{phone}")
    public Integer checkPhone(@PathVariable String phone){
        return studentService.checkPhone(phone);
    }

    @RequestMapping("/checkStudentPassword/{password}")
    public Integer checkStudentPassword(@PathVariable String password,HttpSession session){
        return studentService.checkStudentPassword((Integer) session.getAttribute("studentId"),password);
    }

    //用户注册
    @RequestMapping("/register")
    public Integer studentRegister(@RequestBody Student student,HttpSession session){
        studentService.studentRegister(student.getPhone(),student.getPassword(),student.getName(),student.getSex());
        Integer studentId = studentService.studentLogin(student.getPhone(),student.getPassword());
        session.setAttribute("studentId",studentId);
        return studentId;
    }


    //密码修改
    @RequestMapping("changePassword/{password}")
    public void changePassword(@PathVariable String password,HttpSession session){
        Integer studentId = (Integer) session.getAttribute("studentId");
        studentService.changePassword(password,studentId);
    }


    //获取用户信息
    @RequestMapping("getStudentInfo")
    public Student getStudentInfo(HttpSession session){
        Integer studentId = (Integer) session.getAttribute("studentId");
        return studentService.getStudentInfo(studentId);
    }

    //修改用户信息
    @RequestMapping("changeStudentInfo")
    public void changeStudentInfo(@RequestBody Student student,HttpSession session){
        Integer studentId = (Integer) session.getAttribute("studentId");
        student.setId(studentId);
        studentService.changeStudentInfo(student);
    }



}
