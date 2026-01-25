package com.secondhandtradingsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.secondhandtradingsystem.constant.MessageConstant;
import com.secondhandtradingsystem.dto.GoodsDTO;
import com.secondhandtradingsystem.dto.GoodsPageQueryDTO;
import com.secondhandtradingsystem.entity.Goods;
import com.secondhandtradingsystem.exception.DeletionNotAllowedException;
import com.secondhandtradingsystem.mapper.GoodsMapper;
import com.secondhandtradingsystem.result.PageResult;
import com.secondhandtradingsystem.service.GoodsService;
import com.secondhandtradingsystem.vo.GoodsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 添加商品
     * @param goodsDTO
     */
    @Override
    public void addGoods(GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsDTO, goods);
        goodsMapper.addGoods(goods);
    }

    /**
     * 分页查询
     * @param goodsPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(GoodsPageQueryDTO goodsPageQueryDTO) {
        PageHelper.startPage(goodsPageQueryDTO.getPageNum(), goodsPageQueryDTO.getPageSize());
        Page<GoodsVO> page = goodsMapper.pageQuery(goodsPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据ID查询商品
     * @param id
     * @return
     */
    @Override
    public GoodsVO getById(Long id) {
        //根据id查询商品
        Goods goods = goodsMapper.getById(id);

        GoodsVO goodsVO = new GoodsVO();
        BeanUtils.copyProperties(goods, goodsVO);
        return goodsVO;
    }
    /**
     * 修改商品信息
     * @param goodsDTO
     */
    @Override
    public void update(GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsDTO, goods);
        goodsMapper.update(goods);
    }

    /**
     * 删除商品
     * @param ids
     */
    @Override
    public void deleteBatch(List<Long> ids) {
        //判读当前商品是否能够删除---商品处于上架状态中则不能删除
        for (Long id : ids){
            Goods goods = goodsMapper.getById(id);
            if (goods.getStatus() == 1){
                throw new DeletionNotAllowedException(MessageConstant.GOODS_ON_SALE );
            }
        }
        //批量删除
        for (Long id : ids){
            goodsMapper.deleteById(id);
        }
    }

    /**
     * 商家上下架商品
     * @param status
     * @param id
     */
    @Override
    public void startOrStop(Integer status, Long id) {
        Goods goods = Goods.builder()
                .status(status)
                .id(id)
                .build();
                goodsMapper.update(goods);
    }
}
