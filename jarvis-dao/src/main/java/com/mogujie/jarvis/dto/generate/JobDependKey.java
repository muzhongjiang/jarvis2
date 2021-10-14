package com.mogujie.jarvis.dto.generate;

import lombok.Data;

@Data
public class JobDependKey {
    private Long jobId;
    private Long preJobId;

}