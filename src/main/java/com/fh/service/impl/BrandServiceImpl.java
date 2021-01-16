package com.fh.service.impl;

import com.fh.mapper.BrandMapper;
import com.fh.model.po.Brand;
import com.fh.model.vo.BrandVo;
import com.fh.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;

    @Override
    public Map queryBrand(BrandVo vo) {
     Map rs=new HashMap();
        Integer count =  brandMapper.queryCount(vo);
        rs.put("count",count);
        List<Brand> list=brandMapper.queryBrand(vo);
        rs.put("list",list);
        return rs;
    }

    @Override
    public void addBrand(Brand brand) {
        brand.setCreateDate(new Date());
        brandMapper.addBrand(brand);
    }

    @Override
    public void gtiById(Integer id) {
        brandMapper.gtiById(id);
    }

    @Override
    public void updateBrand(Brand brand) {
        brand.setCreateDate(new Date());
        brandMapper.updateBrand(brand);
    }
}
