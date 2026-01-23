package com.secondhandtradingsystem.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 留言表实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Message extends BaseEntity {

    // 留言ID（主键自增）
    private Long id;

    // 商品ID（关联商品表）
    private Long goodsId;

    // 发送人ID（关联用户表）
    private Long fromUserId;

    // 接收人ID（关联用户表）
    private String toUserId;

    // 留言内容
    private String content;
}
