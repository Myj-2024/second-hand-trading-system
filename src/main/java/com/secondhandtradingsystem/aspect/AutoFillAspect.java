package com.secondhandtradingsystem.aspect;

import com.secondhandtradingsystem.annotation.AutoFill;
import com.secondhandtradingsystem.constant.AutoFillConstant;
import com.secondhandtradingsystem.enums.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Map;

//自定义切面，实现自动填充（仅保留时间字段）
@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    // 切入点
    @Pointcut("execution(* com.secondhandtradingsystem.mapper.*.*(..)) && @annotation(com.secondhandtradingsystem.annotation.AutoFill)")
    public void autoFillPointCut(){
    }

    //前置通知，仅填充时间字段（删除所有user相关逻辑）
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
            OperationType operationType = autoFill.value();

            Object[] args = joinPoint.getArgs();
            if (args == null || args.length == 0 || args[0] == null) {
                log.warn("自动填充：方法参数为空，跳过");
                return;
            }

            Object object = args[0];
            if (object instanceof Map) {
                log.warn("自动填充：参数为Map，跳过");
                return;
            }

            LocalDateTime now = LocalDateTime.now();

            // 仅填充时间字段，完全删除createUser/updateUser相关代码
            if (operationType == OperationType.INSERT) {
                // 填充createTime
                try {
                    object.getClass()
                            .getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class)
                            .invoke(object, now);
                    log.debug("自动填充createTime成功：{}", now);
                } catch (NoSuchMethodException e) {
                    log.warn("实体类{}无setCreateTime方法", object.getClass().getName());
                }
            }

            // 填充updateTime（插入/更新都执行）
            try {
                object.getClass()
                        .getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class)
                        .invoke(object, now);
                log.debug("自动填充updateTime成功：{}", now);
            } catch (NoSuchMethodException e) {
                log.warn("实体类{}无setUpdateTime方法", object.getClass().getName());
            }

        } catch (Exception e) {
            log.error("自动填充失败", e);
        }
    }
}