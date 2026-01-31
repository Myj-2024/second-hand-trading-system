package com.secondhandtradingsystem.mapper;

import com.github.pagehelper.Page;
import com.secondhandtradingsystem.dto.MessagePageQueryDTO;
import com.secondhandtradingsystem.entity.Message;
import com.secondhandtradingsystem.vo.MessageVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {

    /**
     * 分页查询
     * @param messagePageQueryDTO
     * @return
     */
    Page<MessageVO> page(MessagePageQueryDTO messagePageQueryDTO);
}
