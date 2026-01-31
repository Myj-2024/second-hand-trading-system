package com.secondhandtradingsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.secondhandtradingsystem.constant.MessageConstant;
import com.secondhandtradingsystem.dto.CategoryDTO;
import com.secondhandtradingsystem.dto.CategoryPageQueryDTO;
import com.secondhandtradingsystem.entity.Category;
import com.secondhandtradingsystem.exception.DeletionNotAllowedException;
import com.secondhandtradingsystem.mapper.CategoryMapper;
import com.secondhandtradingsystem.mapper.GoodsMapper;
import com.secondhandtradingsystem.result.PageResult;
import com.secondhandtradingsystem.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * 添加分类
     * @param categoryDTO
     */
    @Override
    public void add(CategoryDTO categoryDTO) {
        // 将DTO转换为实体
        Category category = new Category();

        //属性拷贝
        BeanUtils.copyProperties(categoryDTO, category);

        categoryMapper.add(category);
    }

    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @Override
    public PageResult page(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPageNum(), categoryPageQueryDTO.getPageSize());
        Page<Category> page = categoryMapper.page(categoryPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 删除分类
     * @param id
     */
    @Override
    public void delete(Long id) {
        //判断是否有商品关联，如果有商品关联则不能删除，抛出业务异常
        Integer count = goodsMapper.countByCategoryId(id);
        if (count > 0){
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_GOODS);
        }

        //删除分类
        categoryMapper.deleteById(id);
    }


    /**
     * 修改分类
     * @param categoryDTO
     */
    @Override
    public void update(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        categoryMapper.update(category);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchOperateCategoryGoods(Long categoryId, Integer targetStatus) {
        // 1. 参数校验
        if (categoryId == null || targetStatus == null) {
            throw new IllegalArgumentException("分类ID和目标状态不能为空");
        }
        if (!targetStatus.equals(0) && !targetStatus.equals(1)) {
            throw new IllegalArgumentException("目标状态只能是0（下架）或1（上架）");
        }

        // 2. 调用GoodsMapper批量更新商品状态
        // 核心：根据目标状态，更新分类下相反状态的商品
        goodsMapper.batchUpdateGoodsStatusByCategory(categoryId, targetStatus);
    }
}
