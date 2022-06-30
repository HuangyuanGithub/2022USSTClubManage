package com.usst.vo;

import lombok.Data;

@Data
public class StudentActivity {
    private Integer activityId;
    private String activityName;
    private Integer studentId;
    private String name; //学生名字
    private String clubName;
    private String date;
    private Integer clubId;
}
