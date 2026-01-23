package com.secondhandtradingsystem.entity;


import lombok.Data;
import java.math.BigDecimal;

/**
 * 订单详情表实体
 */
@Data
public class OrderDetail {
    // 主键ID
    private Long id;
    // 订单ID
    private Long orderId;
    // 商品名称（冗余）
    private String goodsName;
    // 商品图片（冗余）
    private String goodsImage;
    // 成交价格（冗余）
    private BigDecimal price;
}
