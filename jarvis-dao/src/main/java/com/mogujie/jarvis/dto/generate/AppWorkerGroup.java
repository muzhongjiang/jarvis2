package com.mogujie.jarvis.dto.generate;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class AppWorkerGroup extends AppWorkerGroupKey {
    private Date createTime;
    private Date updateTime;
    private String updateUser;

}