package com.secondhandtradingsystem.dto;

import lombok.Data;
// 核心修改：jakarta → javax
import javax.validation.constraints.NotBlank;

/**
 * 登录请求DTO
 */
@Data
public class UserLoginDTO {
    // 用户名（非空校验）
    @NotBlank(message = "用户名不能为空")
    private String username;

    // 密码（非空校验）
    @NotBlank(message = "密码不能为空")
    private String password;
}