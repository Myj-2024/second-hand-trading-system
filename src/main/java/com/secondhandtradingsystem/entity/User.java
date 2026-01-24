package com.secondhandtradingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Long id; // 对应sys_user.id
    private String username; // 对应sys_user.username
    private String password; // 对应sys_user.password
    private String nickname; // 对应sys_user.nickname
    private String phone; // 对应sys_user.phone
    private String avatar; // 对应sys_user.avatar
    private Integer status; // 对应sys_user.status（0禁用 1正常）
    private LocalDateTime createTime; // 对应sys_user.create_time
    private LocalDateTime updateTime; // 对应sys_user.update_time
    private Integer isDeleted; // 对应sys_user.is_deleted
}
