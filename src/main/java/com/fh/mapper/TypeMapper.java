package com.fh.mapper;

import com.fh.model.po.ProductType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TypeMapper {
    List<Map<String, Object>> query();


    void updateType(ProductType productType);

    void delType(Integer id);

    int addType(ProductType productType);
}
