package com.mogujie.jarvis.dto.generate;

import lombok.Data;

import java.util.Date;

@Data
public class PlanKey {
    private Long jobId;

    private Date planTime;

}