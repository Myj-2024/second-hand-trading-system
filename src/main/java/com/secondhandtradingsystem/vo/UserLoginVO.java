package com.secondhandtradingsystem.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录返回VO（给前端的结果）
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserLoginVO {
    // JWT令牌
    private String token;
    // 用户ID
    private Long userId;
    // 用户名
    private String userName;
    // 昵称
    private String nickName;
}