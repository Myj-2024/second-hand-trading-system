package com.secondhandtradingsystem.service;

import com.secondhandtradingsystem.dto.MessagePageQueryDTO;
import com.secondhandtradingsystem.result.PageResult;

public interface MessageService {

    /**
     * 分页查询
     * @param messagePageQueryDTO
     * @return
     */
    PageResult page(MessagePageQueryDTO messagePageQueryDTO);
}
