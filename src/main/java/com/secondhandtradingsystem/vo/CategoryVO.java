package com.secondhandtradingsystem.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品分类展示VO
 * 用于前端分页列表/单条展示的格式化数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVO implements Serializable {
    /**
     * 分类ID
     */
    private Long id;

    /**
     * 分类名称
     */
    private String categoryName;

//    /**
//     * 排序字段
//     */
//    private Integer sort;

    /**
     * 关联商品总数
     */
    private Integer totalGoodsCount;

    /**
     * 关联上架商品数
     */
    private Integer onlineGoodsCount;

    /**
     * 关联下架商品数
     */
    private Integer offlineGoodsCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}