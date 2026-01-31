package com.secondhandtradingsystem.enums;

import lombok.Getter;

/**
 * 订单状态枚举
 * 0待付款 1待发货 2待收货 3已完成 4已取消
 */
@Getter
public enum OrderStatusEnum {
    PENDING_PAYMENT(0, "待付款"),
    PENDING_DELIVERY(1, "待发货"),
    PENDING_RECEIPT(2, "待收货"),
    COMPLETED(3, "已完成"),
    CANCELED(4, "已取消");

    private final Integer code;
    private final String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    // 根据编码获取枚举
    public static OrderStatusEnum getByCode(Integer code) {
        for (OrderStatusEnum status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }
}
