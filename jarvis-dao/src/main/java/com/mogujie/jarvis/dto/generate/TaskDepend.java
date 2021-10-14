package com.mogujie.jarvis.dto.generate;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDepend {
    private Long taskId;

    private Date createTime;

    private String dependTaskIds;

    private String childTaskIds;

}