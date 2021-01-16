package com.fh.service;


import com.fh.model.po.Attribute;
import com.fh.model.vo.PinPaiData;

import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-14 20:12
 */
public interface AttributeService {
    Map queryAttributeData(PinPaiData pinPaiData);

    void addAttribute(Attribute attribute);

    void updateAttribute(Attribute attribute);

    void deleteAttributeById(Integer id);
}
