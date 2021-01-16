package com.fh.controller;

import com.fh.model.po.ProductType;
import com.fh.model.vo.ResultData;
import com.fh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/type")
@CrossOrigin
public class TypeController {

      @Autowired
    private TypeService typeService;

    @GetMapping("getData")
    public ResultData queryType(){
        Map rs= typeService.queryType();
        return ResultData.success(rs);
    }

    @PostMapping("add")
    public ResultData addType(ProductType productType){

        return typeService.addType(productType);
    }

    @PostMapping("update")
    public ResultData updateType(ProductType productType){
        typeService.updateType(productType);
        return ResultData.success("");
    }

    @DeleteMapping("del")
    public ResultData DelType(Integer id){
        typeService.delType(id);
       return   ResultData.success("");
    }
}
