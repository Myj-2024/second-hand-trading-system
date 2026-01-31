package com.secondhandtradingsystem.mapper;

import com.github.pagehelper.Page;
import com.secondhandtradingsystem.dto.OrderPageQueryDTO;
import com.secondhandtradingsystem.entity.OrderDetail;
import com.secondhandtradingsystem.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.simpleframework.xml.Order;

@Mapper
public interface OrderMapper {

    /**
     * 分页查询
     * @param orderPageQueryDTO
     * @return
     */
    Page<OrderInfo> page(OrderPageQueryDTO orderPageQueryDTO);

    /**
     * 根据id查询订单详情
     * @param order_id
     * @return
     */
    @Select("select * from order_detail where order_id = #{orderId}")
    OrderDetail getById(Long order_id);

    /**
     * 修改订单状态
     * @param orderInfo
     */
    void update(OrderInfo orderInfo);
}
