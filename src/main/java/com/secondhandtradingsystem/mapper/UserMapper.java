package com.secondhandtradingsystem.mapper;

import com.github.pagehelper.Page;
import com.secondhandtradingsystem.annotation.AutoFill;
import com.secondhandtradingsystem.dto.UserDTO;
import com.secondhandtradingsystem.entity.User;
import com.secondhandtradingsystem.enums.OperationType;
import com.secondhandtradingsystem.dto.UserPageQueryDTO;
import org.apache.ibatis.annotations.Insert;
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
    UserDTO selectByUsername(String username);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from sys_user where id = #{userId}")
    UserDTO getById(Long userId);

    /**
     * 添加用户（核心修复：@Insert注解 + 移除isDeleted参数 + 返回int）
     * SQL中：is_deleted固定为0（未删除），create_time/update_time由切面填充
     */
    @Insert("insert into sys_user (" +
            "username, password, nickname, phone, avatar, status, " +
            "create_time, update_time, is_deleted" +
            ") values (" +
            "#{username}, #{password}, #{nickname}, #{phone}, #{avatar}, #{status}, " +
            "#{createTime}, #{updateTime}, 0" +  // is_deleted固定为0，避免null
            ")")
    @AutoFill(value = OperationType.INSERT)  // 触发切面填充createTime/updateTime
    int insert(User user);  // 返回int：1=插入成功，0=失败

    /**
     * 分页查询用户
     * @param userPageQueryDTO
     * @return
     */
    Page<User> pageQuery(UserPageQueryDTO userPageQueryDTO);
}