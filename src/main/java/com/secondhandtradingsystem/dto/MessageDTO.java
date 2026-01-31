package com.secondhandtradingsystem.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class MessageDTO implements Serializable {

    /**
     * 留言ID（主键ID）
     */
    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 发送人ID
     */
    private Long fromUserId;

    /**
     * 接收人ID
     */
    private Long toUserId;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
