package com.secondhandtradingsystem.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表实体（纯 MyBatis 版本）
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {
    // 主键ID
    private Long id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 昵称
    private String nickname;
    // 手机号
    private String phone;
    // 头像URL
    private String avatar;
    // 状态（0禁用，1正常）
    private Integer status;
}
