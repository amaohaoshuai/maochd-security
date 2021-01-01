package com.maochd.security.entity;

import lombok.Data;

import java.util.Date;

/**
 * 业务实体
 *
 * @author maochd
 */
@Data
public class WorkInfo {
    private String workId;
    private String workDetail;
    private Date createDate;
    private Date lastUpdateDate;
}
