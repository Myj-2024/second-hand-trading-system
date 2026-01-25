package com.secondhandtradingsystem.ExceptionHandler;

import com.secondhandtradingsystem.exception.DeletionNotAllowedException;
import com.secondhandtradingsystem.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理商品删除不允许的异常
     */
    @ExceptionHandler(DeletionNotAllowedException.class)
    public Result handleDeletionNotAllowedException(DeletionNotAllowedException e) {
        log.error("删除商品异常：{}", e.getMessage());
        // 返回统一格式的错误响应，message字段携带具体异常信息
        return Result.error(e.getMessage());
    }

    /**
     * 处理其他所有异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("系统异常：", e);
        return Result.error("操作失败，请联系管理员");
    }
}
