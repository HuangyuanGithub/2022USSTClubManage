package com.usst.entity;

import lombok.Data;

@Data
public class ActivityMessage {
    private Integer id;
    private Integer activityId;
    private String message;
    private Integer studentId;
    private String studentName;
}
