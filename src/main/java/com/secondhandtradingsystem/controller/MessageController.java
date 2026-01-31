package com.secondhandtradingsystem.controller;


import com.secondhandtradingsystem.dto.MessagePageQueryDTO;
import com.secondhandtradingsystem.result.PageResult;
import com.secondhandtradingsystem.result.Result;
import com.secondhandtradingsystem.service.MessageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/message")
@Slf4j
@Tag(name = "留言管理")
public class MessageController {


    @Autowired
    private MessageService messageService;


    /**
     * 分页查询
     * @param messagePageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @Tag(name = "分页查询")
    public Result<PageResult> page(MessagePageQueryDTO messagePageQueryDTO){
        log.info("分页查询：{}", messagePageQueryDTO);
        PageResult pageResult = messageService.page(messagePageQueryDTO);
        return Result.success(pageResult);
    }
}
