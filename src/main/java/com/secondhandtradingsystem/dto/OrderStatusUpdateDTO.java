package com.secondhandtradingsystem.dto;


import lombok.Data;
import java.io.Serializable;

/**
 * 订单状态修改DTO
 * 接收前端修改订单状态的参数
 */
@Data
public class OrderStatusUpdateDTO implements Serializable {
    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 目标状态（0-4）
     */
    private Integer status;

    /**
     * 操作人ID（买家/卖家/管理员）
     */
    private Long operatorId;

    /**
     * 取消原因（仅状态为4时必填）
     */
    private String cancelReason;
}
