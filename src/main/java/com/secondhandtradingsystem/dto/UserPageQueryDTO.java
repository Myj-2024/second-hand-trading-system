package com.secondhandtradingsystem.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPageQueryDTO implements Serializable {
    private String username;
    private int pageNum;
    private int pageSize;
    private Integer status;
}
