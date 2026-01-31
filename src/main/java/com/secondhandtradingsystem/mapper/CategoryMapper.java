package com.secondhandtradingsystem.mapper;


import com.github.pagehelper.Page;
import com.secondhandtradingsystem.annotation.AutoFill;
import com.secondhandtradingsystem.dto.CategoryPageQueryDTO;
import com.secondhandtradingsystem.entity.Category;
import com.secondhandtradingsystem.enums.OperationType;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {
    /**
     * 添加分类
     * @param category
     */
    @AutoFill(value = OperationType.INSERT)
    void add(Category category);

    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> page(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 删除分类
     * @param id
     */
    @Delete("DELETE FROM goods_category WHERE id = #{id}")
    void deleteById(Long id);

    /**
     * 修改分类
     * @param category
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Category category);



}
