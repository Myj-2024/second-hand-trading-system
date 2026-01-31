package com.secondhandtradingsystem.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {
    /**
     * 分类ID（修改/查询时用，新增时为空）
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


}