package com.secondhandtradingsystem.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * 商品分类分页查询DTO
 * 用于分页列表查询的参数传输
 */
@Data
public class CategoryPageQueryDTO implements Serializable {
    /**
     * 页码（默认1）
     */
    private Integer pageNum = 1;

    /**
     * 每页条数（默认10）
     */
    private Integer pageSize = 10;

    /**
     * 分类名称（模糊查询）
     */
    private String categoryName;

    private String sort;
}