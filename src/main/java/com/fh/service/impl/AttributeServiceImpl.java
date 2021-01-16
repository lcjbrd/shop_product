package com.fh.service.impl;

import com.fh.mapper.AttributeDao;
import com.fh.model.po.Attribute;
import com.fh.model.vo.PinPaiData;
import com.fh.service.AttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-14 20:13
 */
@Service
public class AttributeServiceImpl implements AttributeService {
    @Resource
    private AttributeDao attributeDao;
    @Override
    public Map queryAttributeData(PinPaiData pinPaiData) {
        Map map = new HashMap();
        Integer count = attributeDao.queryDataCount(pinPaiData);
        List<Attribute> st = attributeDao.queryAttributeData(pinPaiData);
        map.put("count",count);
        map.put("list",st);
        return map;
    }

    @Override
    public void addAttribute(Attribute attribute) {
        attribute.setCreateDate(new Date());
        attributeDao.addAttribute(attribute);
    }

    @Override
    public void updateAttribute(Attribute attribute) {
        attribute.setUpdateDate(new Date());
        attributeDao.updateAttribute(attribute);
    }

    @Override
    public void deleteAttributeById(Integer id) {
        attributeDao.deleteAttributeById(id);
    }

}
