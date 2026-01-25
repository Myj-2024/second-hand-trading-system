package com.secondhandtradingsystem.service;

import com.github.pagehelper.Page;
import com.secondhandtradingsystem.dto.UserLoginDTO;
import com.secondhandtradingsystem.dto.UserDTO;
import com.secondhandtradingsystem.entity.User;
import com.secondhandtradingsystem.dto.UserPageQueryDTO;

import java.util.List;

public interface UserService {

    /**
     * 登录
     * @param userLoginDTO
     * @return
     */
    UserDTO login(UserLoginDTO userLoginDTO);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    UserDTO getById(Long userId);

    /**
     * 添加用户
     * @param userDTO
     */
    void add(UserDTO userDTO);

    /**
     * 分页查询
     * @param userPageQueryDTO
     * @return
     */
    Page<User> pageQuery(UserPageQueryDTO userPageQueryDTO);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User getByUsername(String username);

    /**
     * 批量删除用户
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 修改用户信息
     * @param userDTO
     */
    void update(UserDTO userDTO);

    /**
     * 重置密码
     * @param id
     */
    void resetPassword(Long id);
}
