package com.secondhandtradingsystem.dto;


import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单分页查询DTO
 * 接收前端分页+筛选参数
 */
@Data
public class OrderPageQueryDTO implements Serializable {
    /**
     * 页码（默认1）
     */
    private Integer pageNum = 1;

    /**
     * 每页条数（默认10）
     */
    private Integer pageSize = 10;

    /**
     * 订单编号（精准查询）
     */
    private String orderNo;

    /**
     * 买家ID（买家视角查询）
     */
    private Long buyerId;

    /**
     * 卖家ID（卖家视角查询）
     */
    private Long sellerId;

    /**
     * 订单状态（0-4）
     */
    private Integer status;

    /**
     * 商品名称（模糊查询）
     */
    private String goodsName;

    /**
     * 商品ID（精准查询）
     */
    private Long goodsId;

    /**
     * 价格（模糊查询）
     */
    private BigDecimal price;
}
