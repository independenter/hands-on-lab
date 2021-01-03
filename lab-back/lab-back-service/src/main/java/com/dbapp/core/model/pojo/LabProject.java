package com.dbapp.core.model.pojo;

import java.util.Date;
import lombok.Data;

/**
 * 实验室项目列表
 * @author dobb
 */
@Data
public class LabProject {
    /**
     * 实验室项目的主键
     */
    private Integer id;

    /**
     * 项目名称
     */
    private String title;

    /**
     * 难度
     */
    private Integer difficulty;

    /**
     * 事件(分钟)
     */
    private Integer time;

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
    private Byte open;

    /**
     * 创建时间
     */
    private Date created;
}