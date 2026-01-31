package com.secondhandtradingsystem.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * 留言分页查询DTO
 */
@Data
public class MessagePageQueryDTO implements Serializable {

    /**
     * 页码（默认1）
     */
    private Integer pageNum = 1;

    /**
     * 每页条数（默认10）
     */
    private Integer pageSize = 10;

    /**
     * 订单编号（模糊查询）
     */
    private String orderNo;

    /**
     * 发送人用户名（模糊查询）
     */
    private String fromUserName;

    /**
     * 接收人用户名（模糊查询）
     */
    private String toUserName;
}
