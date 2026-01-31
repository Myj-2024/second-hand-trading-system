package com.secondhandtradingsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.secondhandtradingsystem.dto.MessagePageQueryDTO;
import com.secondhandtradingsystem.entity.Message;
import com.secondhandtradingsystem.mapper.MessageMapper;
import com.secondhandtradingsystem.result.PageResult;
import com.secondhandtradingsystem.service.MessageService;
import com.secondhandtradingsystem.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {


    @Autowired
    private MessageMapper messageMapper;


    /**
     * 分页查询
     * @param messagePageQueryDTO
     * @return
     */
    @Override
    public PageResult page(MessagePageQueryDTO messagePageQueryDTO) {
        PageHelper.startPage(messagePageQueryDTO.getPageNum(), messagePageQueryDTO.getPageSize());
        Page<MessageVO> page = messageMapper.page(messagePageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
