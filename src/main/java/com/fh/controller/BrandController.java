package com.fh.controller;

import com.fh.model.po.Brand;
import com.fh.model.vo.BrandVo;
import com.fh.model.vo.ResultData;
import com.fh.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/brand")
@CrossOrigin
public class BrandController {
   @Autowired
    private BrandService brandService;

    @GetMapping
    public ResultData queryBrand(BrandVo vo){
       Map list =  brandService.queryBrand(vo);
         return ResultData.success(list);
   }

   @PostMapping
    private ResultData addBrand(Brand brand){
        brandService.addBrand(brand);
       return ResultData.success("");
   }

    @GetMapping("getById")
    public ResultData gtiById(Integer id){
       brandService.gtiById(id);
        return  ResultData.success(id);
    }

    @PostMapping("update")
    public ResultData updateBrand(Brand brand){
        brandService.updateBrand(brand);
       return   ResultData.success("");
    }

}
