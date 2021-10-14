package com.mogujie.jarvis.dto.generate;

import lombok.Data;

import java.util.Date;
@Data
public class BizGroup {
    private Integer id;
    private String name;
    private Integer status;
    private String owner;
    private Date createTime;
    private Date updateTime;
    private String updateUser;

}