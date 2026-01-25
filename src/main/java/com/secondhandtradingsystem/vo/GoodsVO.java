package com.secondhandtradingsystem.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 商品展示VO
 * 用于前端分页列表/单条展示的格式化数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVO implements Serializable {
    /**
     * 商品ID
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
     * 分类名称（前端展示用，关联查询补充）
     */
    private String categoryName;

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
     * 商品图片URL列表（拆分逗号分隔字符串为数组，方便前端遍历）
     */
    private String goodsImages;

    /**
     * 状态 0下架 1上架（转中文描述）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
