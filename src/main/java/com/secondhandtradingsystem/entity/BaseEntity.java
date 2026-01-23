package com.secondhandtradingsystem.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 通用基类，抽取公共字段
 */
@Data
public class BaseEntity {
    // 创建时间
    private LocalDateTime createTime;
    // 更新时间
    private LocalDateTime updateTime;
    // 逻辑删除（0未删，1已删）
    private Integer isDeleted;
}
