package com.secondhandtradingsystem.dto;


import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单创建DTO
 * 接收前端下单参数
 */
@Data
public class OrderCreateDTO implements Serializable {
    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 买家ID（前端不传，由登录态获取，此处仅预留）
     */
    private Long buyerId;

    /**
     * 卖家ID（根据商品ID查询获取，此处仅预留）
     */
    private Long sellerId;

    /**
     * 成交价格
     */
    private BigDecimal price;
}
