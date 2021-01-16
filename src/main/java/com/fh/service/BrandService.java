package com.fh.service;

import com.fh.model.po.Brand;
import com.fh.model.vo.BrandVo;

import java.util.Map;

public interface BrandService {
    Map queryBrand(BrandVo vo);

    void addBrand(Brand brand);

    void gtiById(Integer id);

    void updateBrand(Brand brand);


}
