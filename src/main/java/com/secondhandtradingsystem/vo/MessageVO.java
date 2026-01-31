package com.secondhandtradingsystem.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MessageVO implements Serializable {

    /**
     * 留言ID（主键自增）
     */
    private Long id;

    /**
     * 订单ID（关联订单表，用于后台关联，可选：如果前端不需要可隐藏，建议保留）
     */
    private Long orderId;

    /**
     * 订单编号（前端展示用，如 SH2026020100001）
     */
    private String orderNo; // 新增：订单编号

    /**
     * 发送人ID（关联用户表，用于后台关联，可选：前端不需要可隐藏）
     */
    private Long fromUserId;

    /**
     * 发送人用户名（前端展示用，如 admin、zhangsan）
     */
    private String fromUserName; // 新增：发送人用户名

    /**
     * 接收人ID（关联用户表，用于后台关联，可选：前端不需要可隐藏）
     */
    private Long toUserId;

    /**
     * 接收人用户名（前端展示用，如 admin、zhangsan）
     */
    private String toUserName; // 新增：接收人用户名

    /**
     * 留言内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}