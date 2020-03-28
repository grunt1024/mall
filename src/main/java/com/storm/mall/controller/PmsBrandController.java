package com.storm.mall.controller;

import com.storm.mall.common.api.ApiResponse;
import com.storm.mall.common.api.ResultCode;
import com.storm.mall.entity.PmsBrand;
import com.storm.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Description 品牌管理器
 * @Author ZhangHua
 * @CreateTime 2020-03-28 20:41
 */

@Api(tags = "PmsBrandController",description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);


    @ApiOperation("获取所有品牌列表")
    @GetMapping("/listAll")
    public ApiResponse getBrandList(){

        List<PmsBrand> list = brandService.listAllBrand();
        LOGGER.info("获取所有的品牌信息:" + list.toString());
        return new ApiResponse(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),list);
    }


    @ApiOperation("分页获取品牌列表")
    @GetMapping("/list")
    public ApiResponse listBrand(@RequestParam(value = "pageNum",defaultValue = "1")  Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<PmsBrand> list = brandService.listBrand(pageNum,pageSize);
        return new ApiResponse(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),list);
    }


    @ApiOperation("根据 id 获取品牌详情")
    @GetMapping("/{id}")
    public ApiResponse getBrandById(@PathVariable long id){
        PmsBrand brand = brandService.getBrand(id);
        LOGGER.info("根据 id:" + id + "获取品牌信息:" + brand.toString());
        return new ApiResponse(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),brand);
    }




}
