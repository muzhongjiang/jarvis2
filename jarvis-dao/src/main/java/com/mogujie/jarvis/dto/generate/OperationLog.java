package com.mogujie.jarvis.dto.generate;

import lombok.Data;

import java.util.Date;

@Data
public class OperationLog {
    private Integer id;

    private String title;

    private String operator;

    private String refer;

    private Date opeDate;

    private String type;

    private String operationType;

    private String preOperationContent;

    private String afterOperationContent;


}