package com.storm.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.storm.mall.entity.PmsBrand;
import com.storm.mall.entity.PmsBrandExample;
import com.storm.mall.mapper.PmsBrandMapper;
import com.storm.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author ZhangHua
 * @CreateTime 2020-03-28 20:50
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        PmsBrandExample example = new PmsBrandExample();
        example.createCriteria().andShowStatusEqualTo(1);
        return pmsBrandMapper.selectByExample(example);
    }

    @Override
    public int addBrand(PmsBrand brand) {
        return 0;
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        return 0;
    }

    @Override
    public int deleteBrand(Long id) {
        return 0;
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsBrandExample example = new PmsBrandExample();
        example.createCriteria().andShowStatusEqualTo(1);
        return pmsBrandMapper.selectByExample(example);
    }

    @Override
    public PmsBrand getBrand(long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
