package com.secondhandtradingsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.secondhandtradingsystem.dto.OrderPageQueryDTO;
import com.secondhandtradingsystem.entity.OrderDetail;
import com.secondhandtradingsystem.entity.OrderInfo;
import com.secondhandtradingsystem.mapper.OrderMapper;
import com.secondhandtradingsystem.result.PageResult;
import com.secondhandtradingsystem.service.OrderService;
import com.secondhandtradingsystem.vo.OrderDetailVO;
import com.secondhandtradingsystem.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;




    /**
     * 分页查询
     * @param orderPageQueryDTO
     * @return
     */
    @Override
    public PageResult page(OrderPageQueryDTO orderPageQueryDTO) {
        PageHelper.startPage(orderPageQueryDTO.getPageNum(), orderPageQueryDTO.getPageSize());
        Page<OrderInfo> page = orderMapper.page(orderPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据order_id查询订单详情
     * @param order_id
     * @return
     */
    @Override
    public OrderDetailVO details(Long order_id) {
        // 根据id查询订单详情
        OrderDetail orderDetail = orderMapper.getById(order_id);

        //查询该订单对应的商品信息
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        BeanUtils.copyProperties(orderDetail, orderDetailVO);
        return orderDetailVO;
    }

    @Override
    public void update(Integer status, Long id) {
        OrderInfo orderInfo = OrderInfo.builder()
                .id(id)
                .status(status)
                .build();
        orderMapper.update(orderInfo);
    }
}
