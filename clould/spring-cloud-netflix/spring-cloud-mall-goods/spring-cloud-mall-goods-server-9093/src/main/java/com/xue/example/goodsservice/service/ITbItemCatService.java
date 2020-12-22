package com.xue.example.goodsservice.service;

import com.xue.example.goodsservice.mapper.entitys.TbItemCat;

import java.util.List;

public interface ITbItemCatService {
    TbItemCat getGoods(Long id);

    List<TbItemCat> findItemsByIds(List<Long> ids);
}
