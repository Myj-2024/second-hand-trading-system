package com.secondhandtradingsystem.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户实体（完全适配sys_user表字段）
 */
@Data
public class UserDTO implements Serializable {
    private Long id; // 对应sys_user.id

    private String avatar; // 对应sys_user.avatar

    private String password; // 对应sys_user.password

    private Integer status; // 对应sys_user.status（0禁用 1正常）

    private String username; // 对应sys_user.username

    private String nickname; // 对应sys_user.nickname

    private String phone; // 对应sys_user.phone

}