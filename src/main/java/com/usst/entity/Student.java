package com.usst.entity;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private String grade;
    private String major;
    private String introduction;
    private String phone;
    private String password;
}
