package com.secondhandtradingsystem.controller;

import com.github.pagehelper.Page;
import com.secondhandtradingsystem.dto.GoodsDTO;
import com.secondhandtradingsystem.dto.GoodsPageQueryDTO;
import com.secondhandtradingsystem.entity.Goods;
import com.secondhandtradingsystem.mapper.GoodsMapper;
import com.secondhandtradingsystem.result.PageResult;
import com.secondhandtradingsystem.result.Result;
import com.secondhandtradingsystem.service.GoodsService;
import com.secondhandtradingsystem.vo.GoodsVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/goods")
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 添加商品
     * @param goodsDTO
     * @return
     */
    @PostMapping("/add")
    public Result addGoods(@RequestBody GoodsDTO goodsDTO) {
        log.info("添加商品：{}", goodsDTO);
        goodsService.addGoods(goodsDTO);
        return Result.success();
    }


    /**
     * 分页查询商品
     * @param goodsPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> page(GoodsPageQueryDTO goodsPageQueryDTO) {
        log.info("分页查询：{}", goodsPageQueryDTO);
        PageResult pageResult = goodsService.pageQuery(goodsPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据id查询商品和分类
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<GoodsVO> getById(@PathVariable Long id) {
        log.info("根据id查询商品和对应的分类：{}", id);
        GoodsVO goodsVO = goodsService.getById(id);
        return Result.success(goodsVO);
    }

    /**
     * 修改商品信息
     * @param goodsDTO
     */
    @PutMapping("/update")
    public Result update(@RequestBody GoodsDTO goodsDTO) {
        log.info("更新商品信息：{}", goodsDTO);

        // 关键校验：id不能为空
        if (goodsDTO.getId() == null) {
            return Result.error("商品ID不能为空");
        }

        goodsService.update(goodsDTO);
        return Result.success();
    }

    /**
     * 批量删除商品
     * @param ids
     */
    @DeleteMapping("/delete")
    public Result delete(@RequestBody List<Long> ids) {
        log.info("删除商品：{}", ids);
        goodsService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 商品上下架
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    public Result startOrStop(@PathVariable Integer status, @RequestParam Long id){
        log.info("设置商品{}状态为：{}", id, status);


        if (id == null) {
            return Result.error("商品ID不能为空");
        }
        if (status == null || (status != 0 && status != 1)) {
            return Result.error("商品状态只能是0（下架）或1（上架）");
        }

        goodsService.startOrStop(status, id);
        return Result.success();
    }
}
