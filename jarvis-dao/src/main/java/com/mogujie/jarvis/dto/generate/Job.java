package com.mogujie.jarvis.dto.generate;

import lombok.Data;

import java.util.Date;
@Data
public class Job {
    private Long jobId;

    private String jobName;

    private String jobType;

    private Integer status;

    private Integer contentType;

    private String params;

    private String submitUser;

    private Integer priority;

    private Boolean isSerial;

    private Boolean isTemp;

    private Integer appId;

    private Integer workerGroupId;

    private Integer departmentId;

    private String bizGroups;

    private Date activeStartDate;

    private Date activeEndDate;

    private Integer expiredTime;

    private Integer failedAttempts;

    private Integer failedInterval;

    private Date createTime;

    private Date updateTime;

    private String updateUser;

    private String content;

}