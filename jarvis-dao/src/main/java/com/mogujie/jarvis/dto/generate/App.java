package com.mogujie.jarvis.dto.generate;

import lombok.Data;

import java.util.Date;
@Data
public class App {
    private Integer appId;

    private String appName;

    private String appKey;

    private Integer appType;

    private Integer status;

    private Integer maxConcurrency;

    private String owner;

    private Date createTime;

    private Date updateTime;

    private String updateUser;

}