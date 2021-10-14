package com.mogujie.jarvis.dto.generate;

import lombok.Data;

import java.util.Date;

@Data
public class Alarm {
    private Integer id;

    private Long jobId;

    private String alarmType;

    private String receiver;

    private Integer status;

    private Date createTime;
    private Date updateTime;
    private String updateUser;

}