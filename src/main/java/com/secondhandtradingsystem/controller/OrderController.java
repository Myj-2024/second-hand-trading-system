package com.secondhandtradingsystem.controller;



import com.secondhandtradingsystem.dto.OrderPageQueryDTO;
import com.secondhandtradingsystem.entity.OrderInfo;
import com.secondhandtradingsystem.result.PageResult;
import com.secondhandtradingsystem.result.Result;
import com.secondhandtradingsystem.service.OrderService;
import com.secondhandtradingsystem.vo.OrderDetailVO;
import com.secondhandtradingsystem.vo.OrderVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin/order")
@Tag(name = "订单相关接口")

public class OrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 分页查询
     * @param orderPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> page(OrderPageQueryDTO orderPageQueryDTO) {
        log.info("分页查询：{}", orderPageQueryDTO);
        PageResult pageResult = orderService.page(orderPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据id查询订单详情
     * @param order_id
     * @return
     */
    @GetMapping("/details/{order_id}")
    @Tag(name = "根据id查询订单详情")
    public Result<OrderDetailVO> details(@PathVariable(value = "order_id") Long order_id){
        log.info("查询订单详情：{}", order_id);
        OrderDetailVO orderDetailVO = orderService.details(order_id);
        return Result.success(orderDetailVO);
    }

    /**
     * 修改订单状态
     * @param status
     * @param id
     * @return
     */
    @GetMapping("/status/{status}")
    public Result<String> update(@PathVariable Integer status, Long id){
        log.info("修改订单状态：{}", status);
        orderService.update(status, id);
        return Result.success();
    }
}
