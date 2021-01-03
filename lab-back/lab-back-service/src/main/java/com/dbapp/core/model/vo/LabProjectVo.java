package com.dbapp.core.model.vo;

import lombok.Data;

@Data
public class LabProjectVo {

    /**
     * 项目名称
     */
    private String title;

    /**
     * 难度
     */
    private String difficulty;

    /**
     * 事件(分钟)
     */
    private String time;

    /**
     * 描述
     */
    private String description;

    /**
     * 跳转地址
     */
    private String href;

    /**
     * 是否开放
     */
    private boolean open;
}
