package com.storm.mall.service;

import com.storm.mall.entity.PmsBrand;

import java.util.List;

/**
 * @Description
 * @Author ZhangHua
 * @CreateTime 2020-03-28 20:44
 */
public interface PmsBrandService {


    /**
     * 所有品牌列表
     * @return
     */
    List<PmsBrand> listAllBrand();

    /**
     * 新增品牌
     * @param brand
     * @return
     */
    int addBrand(PmsBrand brand);

    /**
     * 更新品牌数据
     * @param id
     * @param brand
     * @return
     */
    int updateBrand(Long id, PmsBrand brand);

    /**
     * 根据 id 删除品牌
     * @param id
     * @return
     */
    int deleteBrand(Long id);


    /**
     * 分页返回品牌数据
     * @param pageNum 第几页
     * @param pageSize 每页多少数据
     * @return
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * 或者品牌详情数据
     * @param id
     * @return
     */
    PmsBrand getBrand(long id);
}
