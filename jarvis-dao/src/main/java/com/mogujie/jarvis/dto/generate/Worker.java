package com.mogujie.jarvis.dto.generate;

import lombok.Data;

import java.util.Date;

@Data
public class Worker {
    private Integer id;

    private String ip;

    private Integer port;

    private Integer workerGroupId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}