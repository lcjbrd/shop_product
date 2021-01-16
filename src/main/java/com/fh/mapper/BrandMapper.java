package com.fh.mapper;

import com.fh.model.po.Brand;
import com.fh.model.vo.BrandVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BrandMapper {
    Integer queryCount(BrandVo vo);

    List<Brand> queryBrand(BrandVo vo);

    void addBrand(Brand brand);

    void gtiById(Integer id);

    void updateBrand(Brand brand);

}
