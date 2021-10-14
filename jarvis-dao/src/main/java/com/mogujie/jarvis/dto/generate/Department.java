package com.mogujie.jarvis.dto.generate;

import lombok.Data;

import java.util.Date;
@Data
public class Department {
    private Integer id;

    private String name;

    private Date createTime;

    private Date updateTime;

    private String updateUser;


}