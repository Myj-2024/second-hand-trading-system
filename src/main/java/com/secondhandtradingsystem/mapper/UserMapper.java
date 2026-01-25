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

import java.util.List;

/**
 * 用户Mapper（适配sys_user表）
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户
     * 匹配sys_user表：username字段，且is_deleted=0（未逻辑删除）
     */
    @Select("select * from sys_user where username = #{username} and is_deleted = 0")
    User getByUsername(String username);

    /**
     * 根据用户名查询用户
     * 匹配sys_user表：username字段，且is_deleted=0（未逻辑删除）
     */
    @Select("select * from sys_user where username = #{username} and is_deleted = 0")
    UserDTO selectByUsername(String username);

    /**
     * 根据id查询用户
     * @param userId 用户ID
     * @return 用户DTO
     */
    @Select("select * from sys_user where id = #{userId} and is_deleted = 0")
    UserDTO getById(Long userId);

    /**
     * 添加用户（保留原有逻辑，is_deleted固定为0）
     * SQL中：is_deleted固定为0（未删除），create_time/update_time由切面填充
     */
    @Insert("insert into sys_user (" +
            "username, password, nickname, phone, avatar, status, " +
            "create_time, update_time, is_deleted" +
            ") values (" +
            "#{username}, #{password}, #{nickname}, #{phone}, #{avatar}, #{status}, " +
            "#{createTime}, #{updateTime}, 0" +
            ")")
    @AutoFill(value = OperationType.INSERT)
    int insert(User user);  // 返回int：1=插入成功，0=失败

    /**
     * 分页查询用户
     * @param userPageQueryDTO 分页查询条件
     * @return 分页用户列表
     */
    Page<User> pageQuery(UserPageQueryDTO userPageQueryDTO);

    /**
     * 批量逻辑删除用户
     * @param ids 用户ID列表
     * @return 受影响行数
     */
    int deleteBatch(List<Long> ids);

    /**
     * 修改用户信息
     * @param user 用户信息（必须包含id）
     * @return 受影响行数（1=成功，0=用户不存在）
     */
    @AutoFill(value = OperationType.UPDATE)
    int update(User user);
}