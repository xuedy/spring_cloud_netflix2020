package com.xue.example.goodsservice.controller;

import com.xue.example.goodsservice.mapper.entitys.TbItemCat;
import com.xue.example.goodsservice.service.ITbItemCatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "Controller 测试类")
@RestController
public class TbItemCatController {
    @Autowired
    ITbItemCatService iTbItemCatService;
    @ApiOperation(value = "测试方法",produces = "application/json")
    @ApiResponse(code = 200, message = "success", response = TbItemCat.class)
    @GetMapping("/goods/{id}")
    public TbItemCat getById(@PathVariable Long id){
        return iTbItemCatService.getGoods(id);
    }
}
