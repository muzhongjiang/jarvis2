package com.mogujie.jarvis.dto.generate;

import lombok.Data;

import java.util.Date;

@Data
public class JobScheduleExpression {
    private Long id;

    private Long jobId;

    private Integer expressionType;

    private String expression;

    private Date createTime;

    private Date updateTime;

}