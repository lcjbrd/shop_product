package com.fh.service;

import com.fh.model.po.ProductType;
import com.fh.model.vo.ResultData;

import java.util.Map;

public interface TypeService {
    Map queryType();

    ResultData addType(ProductType productType);

    void updateType(ProductType productType);

    void delType(Integer id);
}
