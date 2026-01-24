package com.secondhandtradingsystem.mapper;

import com.secondhandtradingsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户Mapper（适配sys_user表）
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户（登录核心方法）
     * 匹配sys_user表：username字段，且is_deleted=0（未逻辑删除）
     */
    @Select("select * from sys_user where username = #{username}")
    User selectByUsername(String username);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from sys_user where id = #{userId}")
    User getById(Long userId);
}