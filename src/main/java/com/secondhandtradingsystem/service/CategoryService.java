package com.secondhandtradingsystem.service;

import com.secondhandtradingsystem.dto.CategoryDTO;
import com.secondhandtradingsystem.dto.CategoryPageQueryDTO;
import com.secondhandtradingsystem.result.PageResult;

import javax.validation.constraints.NotNull;

public interface CategoryService {

    /**
     * 添加分类
     * @param categoryDTO
     */
    void add(CategoryDTO categoryDTO);


    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult page(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 删除分类
     * @param id
     */
    void delete(Long id);

    /**
     * 修改分类
     * @param categoryDTO
     */
    void update(CategoryDTO categoryDTO);


    /**
     * 批量操作分类商品
     * @param categoryId 分类ID
     * @param targetStatus 目标状态
     */
    void batchOperateCategoryGoods(@NotNull(message = "分类ID不能为空") Long categoryId, @NotNull(message = "目标状态不能为空") Integer targetStatus);
}
