package com.secondhandtradingsystem.service;

import com.secondhandtradingsystem.dto.GoodsDTO;
import com.secondhandtradingsystem.dto.GoodsPageQueryDTO;
import com.secondhandtradingsystem.entity.Goods;
import com.secondhandtradingsystem.result.PageResult;
import com.secondhandtradingsystem.vo.GoodsVO;

import java.util.List;

public interface GoodsService {

    /**
     * 添加商品
     * @param goodsDTO
     */
    void addGoods(GoodsDTO goodsDTO);

    /**
     * 分页查询
     * @param goodsPageQueryDTO
     * @return
     */
    PageResult pageQuery(GoodsPageQueryDTO goodsPageQueryDTO);

    /**
     * 根据ID查询商品
     * @param id
     * @return
     */
    GoodsVO getById(Long id);

    /**
     * 修改商品信息
     * @param goodsDTO
     */
    void update(GoodsDTO  goodsDTO);

    /**
     * 批量删除商品
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 商品上下架
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);
}
