package com.fh.service.impl;

import com.fh.mapper.TypeMapper;
import com.fh.model.po.ProductType;
import com.fh.model.vo.ResultData;
import com.fh.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeMapper typeMapper;

    @Override
    public Map queryType() {
        Map rs=new HashMap();
        List<Map<String ,Object>> allList= typeMapper.query();//所有集合

        List<Map<String,Object>> typeList=new ArrayList<>();//所有根目录
        for (Map<String, Object> allMap : allList) {
            if (allMap.get("pid").equals(0)) {
                typeList.add(allMap);//所有根目录放进
            }
        }
        getChildren(allList,typeList);
        rs.put("typeList",typeList);
        return rs;
    }

    @Override
    public ResultData addType(ProductType productType) {
        productType.setCreateDate(new Date());
        int insertNum =typeMapper.addType(productType);
        System.out.println("1111111111111");
        System.out.println(productType.getId());
        return ResultData.success(productType.getId());
    }

    @Override
    public void updateType(ProductType productType) {
        productType.setUpdateDate(new Date());
        typeMapper.updateType(productType);
    }

    @Override
    public void delType(Integer id) {

        typeMapper.delType(id);
    }

    private void getChildren(List<Map<String, Object>> allList, List<Map<String, Object>> typeList) {
        if (typeList!=null && typeList.size()>0){
            for (Map<String, Object> pmap : typeList) {
                List<Map<String,Object>> children = new ArrayList<>();
                for (Map<String,Object> allMap : allList) {
                    if (pmap.get("id").equals(allMap.get("pid"))){
                        children.add(allMap);
                    }
                }
                //当子节点大于0
                if (children.size()>0){
                    pmap.put("children",children);
                    getChildren(allList,children);
                }
            }
        }
    }
}
