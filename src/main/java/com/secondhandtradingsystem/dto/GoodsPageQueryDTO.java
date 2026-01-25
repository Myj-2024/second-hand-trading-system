package com.secondhandtradingsystem.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品分页查询DTO
 * 用于分页列表查询的参数传输
 */
@Data
public class GoodsPageQueryDTO implements Serializable {
    /**
     * 页码（默认1）
     */
    private Integer pageNum = 1;

    /**
     * 每页条数（默认10）
     */
    private Integer pageSize = 10;

    /**
     * 商品名称（模糊查询）
     */
    private String goodsName;

    /**
     * 分类ID（精准查询）
     */
    private Long categoryId;

    /**
     * 状态 0下架 1上架（精准查询）
     */
    private Integer status;
}
