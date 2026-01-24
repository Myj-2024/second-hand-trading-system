package com.secondhandtradingsystem.service;

import com.secondhandtradingsystem.dto.UserLoginDTO;
import com.secondhandtradingsystem.entity.User;
import com.secondhandtradingsystem.vo.UserLoginVO;

public interface UserService {

    /**
     * 登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    User getById(Long userId);
}
