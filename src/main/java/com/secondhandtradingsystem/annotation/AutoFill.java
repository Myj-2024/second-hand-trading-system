package com.secondhandtradingsystem.annotation;


import com.secondhandtradingsystem.enums.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自动填充注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {

    // 填充逻辑对应的数据库操作类型
    OperationType value();
}
