package com.usst.entity;

import lombok.Data;

@Data
public class ClubMessage {
    private Integer id;
    private Integer clubId;
    private String message;
    private Integer studentId;
    private String studentName;
}
