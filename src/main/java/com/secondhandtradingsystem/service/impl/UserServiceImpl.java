package com.secondhandtradingsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.secondhandtradingsystem.constant.MessageConstant;
import com.secondhandtradingsystem.constant.PasswordConstant;
import com.secondhandtradingsystem.constant.StatusConstant;
import com.secondhandtradingsystem.dto.UserLoginDTO;
import com.secondhandtradingsystem.dto.UserDTO;
import com.secondhandtradingsystem.entity.User;
import com.secondhandtradingsystem.exception.AccountLockedException;
import com.secondhandtradingsystem.exception.PasswordErrorException;
import com.secondhandtradingsystem.mapper.UserMapper;
import com.secondhandtradingsystem.dto.UserPageQueryDTO;
import com.secondhandtradingsystem.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param userLoginDTO
     * @return
     */
    public UserDTO login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        //根据用户名查询用户
        UserDTO user = userMapper.selectByUsername(username);

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
    public UserDTO getById(Long userId) {
        return userMapper.getById(userId);
    }

    /**
     * 添加用户
     * @param userDTO
     */
    @Override
    public void add(UserDTO userDTO) {
        User user = new User();

        //对象属性拷贝
        BeanUtils.copyProperties(userDTO, user);
        //设置账号状态，默认正常状态，1表示正常，0表示锁定
        user.setStatus(StatusConstant.ENABLE);

        //设置密码，默认密码123456
        user.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));

        // 执行插入并校验结果
        int rows = userMapper.insert(user);
        if (rows == 0) {
            throw new RuntimeException(MessageConstant.USER_ADD_FAILED); // 需在MessageConstant中添加该常量
        }

    }

    /**
     * 分页查询
     * @param userPageQueryDTO
     * @return
     */
    @Override
    public Page<User> pageQuery(UserPageQueryDTO userPageQueryDTO) {
        // 1. 适配前端传的pageNum（前端传pageNum，后端DTO是page，先赋值）
        // 若前端传pageNum，后端DTO没有该字段，先手动映射（或修改DTO字段名）
        int pageNum = userPageQueryDTO.getPageNum();
        int pageSize = userPageQueryDTO.getPageSize();

        // 2. 页码适配：PageHelper从1开始，pageNum<1则设为1
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 10 : pageSize;

        // 3. ✅ 正确：startPage在Mapper查询前执行
        PageHelper.startPage(pageNum, pageSize);

        // 4. 执行Mapper查询（确保Mapper的pageQuery方法接收UserPageQueryDTO）
        List<User> userList = userMapper.pageQuery(userPageQueryDTO);

        // 5. 转换为Page对象
        return (Page<User>) userList;
    }
}
