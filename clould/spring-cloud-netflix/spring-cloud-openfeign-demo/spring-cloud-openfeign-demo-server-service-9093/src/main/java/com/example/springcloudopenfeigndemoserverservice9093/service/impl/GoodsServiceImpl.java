package com.example.springcloudopenfeigndemoserverservice9093.service.impl;

import com.xue.example.dto.GoodsDto;
import com.xue.example.service.IGoodsService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsServiceImpl implements IGoodsService {
    @Override
    public String getGoods() {
        return "ALL GOODS";
    }

    @Override
    public int addGoods(GoodsDto goodsDto) {
        return 1;
    }
}
