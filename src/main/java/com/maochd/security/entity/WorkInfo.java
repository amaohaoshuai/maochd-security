package com.maochd.security.entity;

import lombok.Data;

import java.util.Date;

@Data
public class WorkInfo {
    private String workId;
    private String workDetail;
    private Date createDate;
    private Date lastUpdateDate;
}
