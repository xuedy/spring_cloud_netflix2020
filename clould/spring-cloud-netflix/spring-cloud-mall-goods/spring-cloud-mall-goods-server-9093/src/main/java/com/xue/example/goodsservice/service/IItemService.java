package com.xue.example.goodsservice.service;

import com.xue.example.dto.ItemStockDto;
import com.xue.example.goodsservice.domain.ItemStockDo;
import com.xue.example.goodsservice.mapper.entitys.TbItem;

import java.util.List;

public interface IItemService {

    List<TbItem> findItemsByIds(List<Long> ids);

    boolean decreaseStock(List<ItemStockDo> itemStockDos);
}
