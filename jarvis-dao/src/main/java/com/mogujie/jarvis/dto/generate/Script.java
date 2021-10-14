package com.mogujie.jarvis.dto.generate;

import lombok.Data;

@Data
public class Script {
    private Integer id;

    private String title;

    private String type;

    private String creator;

    private Long createTime;

    private Long updateTime;

    private String last_editor;

    private Integer status;

    private String content;

}