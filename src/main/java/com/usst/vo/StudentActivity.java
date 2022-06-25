package com.usst.vo;

import lombok.Data;

@Data
public class StudentActivity {
    private int activityId;
    private String activityName;
    private int studentId;
    private String name; //学生名字
    private String clubName;
}
