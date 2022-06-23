package com.usst.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Activity {
    private Integer id;
    private String name;
    private Integer clubId;
    private String introduction;
    private Date date;
}
