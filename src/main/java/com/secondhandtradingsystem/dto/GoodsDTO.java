package com.secondhandtradingsystem.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class GoodsDTO implements Serializable{
    /**
     * 商品ID（修改/查询时用，新增时为空）
     */
    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 原价
     */
    private BigDecimal originalPrice;

    /**
     * 商品描述
     */
    private String goodsDesc;

    /**
     * 商品图片URL（新增/修改时传数组，查询返回逗号分隔字符串）
     */
    private String goodsImages;

    /**
     * 状态 0下架 1上架
     */
    private Integer status;
}
