package com.secondhandtradingsystem.mapper;

import com.github.pagehelper.Page;
import com.secondhandtradingsystem.annotation.AutoFill;
import com.secondhandtradingsystem.dto.GoodsPageQueryDTO;
import com.secondhandtradingsystem.entity.Goods;
import com.secondhandtradingsystem.enums.OperationType;
import com.secondhandtradingsystem.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

    /**
     * 添加商品
     *
     * @param goods 商品信息
     */
    @AutoFill(value = OperationType.INSERT)
    void addGoods(Goods goods);

    /**
     * 分页查询
     *
     * @param goodsPageQueryDTO 分页查询参数
     * @return 商品列表
     */
    Page<GoodsVO> pageQuery(GoodsPageQueryDTO goodsPageQueryDTO);

    /**
     * 根据ID查询商品
     *
     * @param id 商品ID
     * @return 商品信息
     */
    @Select("SELECT * FROM goods_info WHERE id = #{id}")
    Goods getById(Long id);

    /**
     * 修改商品信息
     *
     * @param goods 商品信息
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Goods goods);


    /**
     * 删除商品
     *
     * @param id 商品ID
     */
    @Select("DELETE FROM goods_info WHERE id = #{id}")
    void deleteById(Long id);

    /**
     * 根据分类ID查询商品数量
     *
     * @param id 分类ID
     * @return 商品数量
     */
    @Select("SELECT COUNT(id) FROM goods_info WHERE category_id = #{id}")
    Integer countByCategoryId(Long id);


    /**
     * 批量更新分类下商品状态
     * @param categoryId 分类ID
     * @param targetStatus 目标状态
     */
    void batchUpdateGoodsStatusByCategory(
            @Param("categoryId") Long categoryId,
            @Param("targetStatus") Integer targetStatus
    );
}
