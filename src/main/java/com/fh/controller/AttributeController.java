package com.fh.controller;

import com.fh.model.po.Attribute;
import com.fh.model.vo.PinPaiData;
import com.fh.model.vo.ResultData;
import com.fh.service.AttributeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author cyl
 * @create 2021-01-14 20:07
 */
@RequestMapping("api/attribute")
@CrossOrigin
@RestController
public class AttributeController {

    @Resource
    private AttributeService attributeService;
    /*1    查询所有的属性数据
        路径   http://192.168.1.100:8080/api/attribute/queryAttributeData
        get请求
         参数  size  start  两个参数必传
        返回值   {"code":200,"message":"提示",data:[{*}]}*/
    @GetMapping("queryAttributeData")
    public ResultData queryAttributeData(PinPaiData pinPaiData){
        if (pinPaiData.getCurrPage()==null){
            return ResultData.error(500,"参数错误");
        }
        if (pinPaiData.getSize()==null){
            return ResultData.error(500,"参数错误");
        }
        Map map=  attributeService.queryAttributeData(pinPaiData);
        return ResultData.success(map);
    }
    /*2    新增属性数据
        路径   http://192.168.1.100:8080/api/attribute/addAttribute
        post请求
         参数  attribute对象
        返回值   {"code":200,"message":"提示",data:""}*/
    @PostMapping("addAttribute")
    public ResultData addAttribute(Attribute attribute){
       attributeService.addAttribute(attribute);
        return ResultData.success("");
    }
    /*3    新增属性数据
    路径   http://192.168.1.100:8080/api/attribute/updateAttribute
    post请求
     参数  attribute对象
    返回值   {"code":200,"message":"提示",data:""}*/
    @PostMapping("updateAttribute")
    public ResultData updateAttribute(Attribute attribute){
        if (attribute.getId()==null){
            return ResultData.error(500,"参数错误");
        }
        attributeService.updateAttribute(attribute);
        return ResultData.success("");
    }
    /*4    假删除属性数据
路径   http://192.168.1.100:8080/api/attribute/deleteAttributeById
post请求
 参数  id  必传
返回值   {"code":200,"message":"提示",data:""}*/
    @PostMapping("deleteAttributeById")
    public ResultData deleteAttributeById(Integer id){
        if (id==null){
            return ResultData.error(500,"参数错误");
        }
        attributeService.deleteAttributeById(id);
        return ResultData.success("");
    }




}
