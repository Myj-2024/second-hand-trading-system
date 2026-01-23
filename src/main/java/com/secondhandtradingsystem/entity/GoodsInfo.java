package com.secondhandtradingsystem.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

/**
 * 商品表实体（纯 MyBatis 版本）
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GoodsInfo extends BaseEntity {
    // 主键ID
    private Long id;
    // 商品名称
    private String goodsName;
    // 分类ID
    private Long categoryId;
    // 商品价格
    private BigDecimal price;
    // 原价
    private BigDecimal originalPrice;
    // 商品描述
    private String goodsDesc;
    // 商品图片URL（逗号分隔）
    private String goodsImages;
    // 状态（0下架，1上架）
    private Integer status;
    // 发布人ID
    private Long userId;
}
