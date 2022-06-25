package com.usst.entity;

import lombok.Data;

@Data
public class ActivityImg {
    private Integer id;
    private Integer activityId;
    private String path;
    private String introduction;
}
