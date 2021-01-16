package com.fh.mapper;

import com.fh.model.po.Attribute;
import com.fh.model.vo.PinPaiData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cyl
 * @create 2021-01-14 20:14
 */
@Mapper
public interface AttributeDao {
    Integer queryDataCount(PinPaiData pinPaiData);

    List<Attribute> queryAttributeData(PinPaiData pinPaiData);

    void addAttribute(Attribute attribute);

    void updateAttribute(Attribute attribute);

    void deleteAttributeById(Integer id);
}
