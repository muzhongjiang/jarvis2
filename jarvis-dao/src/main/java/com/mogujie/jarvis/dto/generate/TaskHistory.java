package com.mogujie.jarvis.dto.generate;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class TaskHistory extends TaskHistoryKey {
    private Long jobId;

    private String params;

    private Date scheduleTime;

    private Date dataTime;

    private Float progress;

    private Integer type;

    private Integer status;

    private String finishReason;

    private Integer appId;

    private Integer workerId;

    private String executeUser;

    private Date executeStartTime;

    private Date executeEndTime;

    private Date createTime;

    private Date updateTime;

    private Integer alarmEnable;

    private String content;


}