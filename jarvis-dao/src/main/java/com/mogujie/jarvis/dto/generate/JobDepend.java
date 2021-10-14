package com.mogujie.jarvis.dto.generate;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class JobDepend extends JobDependKey {
    private Integer commonStrategy;
    private String offsetStrategy;
    private Date createTime;
    private Date updateTime;
    private String updateUser;

}