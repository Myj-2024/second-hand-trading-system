package com.secondhandtradingsystem.service.impl;

import com.secondhandtradingsystem.constant.MessageConstant;
import com.secondhandtradingsystem.constant.StatusConstant;
import com.secondhandtradingsystem.dto.UserLoginDTO;
import com.secondhandtradingsystem.entity.User;
import com.secondhandtradingsystem.exception.AccountLockedException;
import com.secondhandtradingsystem.exception.PasswordErrorException;
import com.secondhandtradingsystem.mapper.UserMapper;
import com.secondhandtradingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param userLoginDTO
     * @return
     */
    public User login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        //根据用户名查询用户
        User user = userMapper.selectByUsername(username);

        //处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (user == null){
            // 用户不存在
            throw new ArithmeticException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对：对前端传过来的明文密码进行MD5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if (!password.equals(user.getPassword())){
            // 密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (user.getStatus() == StatusConstant.DISABLE){
            // 账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }
        // 返回登录用户
        return user;
    }


    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Override
    public User getById(Long userId) {
        return userMapper.getById(userId);
    }
}
