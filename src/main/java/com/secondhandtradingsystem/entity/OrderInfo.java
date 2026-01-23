package com.secondhandtradingsystem.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

/**
 * 订单表实体（纯 MyBatis 版本）
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderInfo extends BaseEntity {
    // 主键ID
    private Long id;
    // 订单编号
    private String orderNo;
    // 商品ID
    private Long goodsId;
    // 买家ID
    private Long buyerId;
    // 卖家ID
    private Long sellerId;
    // 成交价格
    private BigDecimal price;
    // 订单状态（0待付款，1待发货，2待收货，3已完成，4已取消）
    private Integer status;
}
