package com.secondhandtradingsystem.service;

import com.secondhandtradingsystem.dto.OrderPageQueryDTO;
import com.secondhandtradingsystem.result.PageResult;
import com.secondhandtradingsystem.vo.OrderDetailVO;
import com.secondhandtradingsystem.vo.OrderVO;

public interface OrderService {

    /**
     * 分页查询
     * @param orderPageQueryDTO
     * @return
     */
    PageResult page(OrderPageQueryDTO orderPageQueryDTO);

    /**
     * 根据id查询订单详情
     * @param order_id
     * @return
     */
    OrderDetailVO details(Long order_id);

    /**
     * 修改订单状态
     * @param status
     * @param id
     */
    void update(Integer status, Long id);
}
