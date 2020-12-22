package com.xue.example.service;

import com.xue.example.dto.GoodsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface IGoodsService {
   @GetMapping("/all")
   String getGoods();
   @PostMapping("/add")
   int addGoods(GoodsDto goodsDto);
}
