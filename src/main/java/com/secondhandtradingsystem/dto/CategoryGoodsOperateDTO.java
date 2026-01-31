package com.secondhandtradingsystem.dto;


import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 分类下商品批量操作DTO
 */
@Data
public class CategoryGoodsOperateDTO {
    /**
     * 分类ID
     */
    @NotNull(message = "分类ID不能为空")
    private Long categoryId;

    /**
     * 目标状态：1-上架 0-下架
     */
    @NotNull(message = "目标状态不能为空")
    private Integer targetStatus;
}
