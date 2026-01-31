package com.secondhandtradingsystem.controller;


import com.secondhandtradingsystem.dto.CategoryDTO;
import com.secondhandtradingsystem.dto.CategoryGoodsOperateDTO;
import com.secondhandtradingsystem.dto.CategoryPageQueryDTO;
import com.secondhandtradingsystem.result.PageResult;
import com.secondhandtradingsystem.result.Result;
import com.secondhandtradingsystem.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/category")
@Tag(name = "分类相关接口")
@Slf4j
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    /**
     * 添加分类
     * @param categoryDTO
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody CategoryDTO categoryDTO){
        log.info("添加分类：{}", categoryDTO);
        categoryService.add(categoryDTO);
        return Result.success();
    }

    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分页查询：{}", categoryPageQueryDTO);
        PageResult pageResult = categoryService.page(categoryPageQueryDTO);
        return Result.success(pageResult);
    }


    /**
     * 删除分类
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result<String> delete(Long  id){
        log.info("删除分类：{}", id);
        categoryService.delete(id);
        return Result.success();
    }


    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody  CategoryDTO categoryDTO){
        log.info("修改分类：{}", categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }



    /**
     * 新增：批量操作分类下商品状态（一键上架/下架）
     */
    @PostMapping("/batchOperateGoods")
    @Tag(name = "批量操作分类下商品状态")
    public Result<String> batchOperateGoods(@Validated @RequestBody CategoryGoodsOperateDTO dto) {
        log.info("批量操作分类下商品状态：分类ID={}, 目标状态={}", dto.getCategoryId(), dto.getTargetStatus());
        categoryService.batchOperateCategoryGoods(dto.getCategoryId(), dto.getTargetStatus());
        return Result.success("商品状态操作成功");
    }
}
