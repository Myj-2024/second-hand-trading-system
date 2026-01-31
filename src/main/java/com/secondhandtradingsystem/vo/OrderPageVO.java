package com.secondhandtradingsystem.vo;


import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * 订单分页返回VO
 * 封装分页参数+订单列表
 */
@Data
public class OrderPageVO implements Serializable {
    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 订单列表
     */
    private List<OrderVO> orderList;
}
