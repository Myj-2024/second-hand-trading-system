package com.secondhandtradingsystem.controller;


import com.secondhandtradingsystem.constant.JwtClaimsConstant;
import com.secondhandtradingsystem.dto.UserLoginDTO;
import com.secondhandtradingsystem.entity.User;
import com.secondhandtradingsystem.mapper.UserMapper;
import com.secondhandtradingsystem.properties.JwtProperties;
import com.secondhandtradingsystem.service.UserService;
import com.secondhandtradingsystem.util.JwtUtil;
import com.secondhandtradingsystem.util.Result;
import com.secondhandtradingsystem.vo.UserLoginVO;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/admin/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 用戶登录
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录：{}", userLoginDTO);
        User user = userService.login(userLoginDTO);

        //登录成功后，生成jwt token返回给前端
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .userId(user.getId())
                .userName(user.getUsername())
                .nickName(user.getNickname())
                .token(token)
                .build();

        return Result.success(userLoginVO);
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    @GetMapping("/info")
    public Result<Map<String, Object>> getUserInfo(@RequestParam String token) {
        try {
            // 1. 解析token获取用户ID
            Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
            Long userId = Long.valueOf(claims.get(JwtClaimsConstant.USER_ID).toString());

            // 2. 查询用户信息
            User user = userService.getById(userId);
            if (user == null) {
                return Result.error("用户不存在");
            }

            // 3. 构造前端期望的字段（name/avatar）
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("name", user.getUsername()); // 前端默认取name字段
            userInfo.put("avatar", user.getAvatar() == null ? "" : user.getAvatar()); // 无头像返回空

            return Result.success(userInfo);
        } catch (Exception e) {
            log.error("获取用户信息失败", e);
            return Result.error("Verification failed, please Login again.");
        }
    }

    /**
     * 用户登出
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }
}
