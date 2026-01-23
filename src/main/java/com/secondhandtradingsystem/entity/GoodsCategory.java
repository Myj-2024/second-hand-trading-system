package com.secondhandtradingsystem.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品分类表实体（纯 MyBatis 版本）
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GoodsCategory extends BaseEntity {
    // 主键ID
    private Long id;
    // 分类名称
    private String categoryName;
    // 排序字段
    private Integer sort;
}