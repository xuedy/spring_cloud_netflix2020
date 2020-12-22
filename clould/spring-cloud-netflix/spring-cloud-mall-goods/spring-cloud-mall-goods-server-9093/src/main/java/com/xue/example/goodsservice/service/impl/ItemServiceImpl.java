package com.xue.example.goodsservice.service.impl;

import com.xue.example.dto.ItemStockDto;
import com.xue.example.exception.BizException;
import com.xue.example.goodsservice.domain.ItemStockDo;
import com.xue.example.goodsservice.mapper.entitys.TbItem;
import com.xue.example.goodsservice.mapper.entitys.TbItemExample;
import com.xue.example.goodsservice.mapper.persistence.TbItemMapper;
import com.xue.example.goodsservice.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ItemServiceImpl implements IItemService {
    @Autowired
    TbItemMapper tbItemMapper;

    @Override
    public List<TbItem> findItemsByIds(List<Long> ids) {
        TbItemExample example =new TbItemExample();
        example.createCriteria().andIdIn(ids);
        return tbItemMapper.selectByExample(example);
    }

    @Transactional
    @Override
    public boolean decreaseStock(List<ItemStockDo> itemStockDos) {
        //获取集合中的某个字段的集合
        List<Long> ids=itemStockDos.stream().map(ItemStockDo::getItemId).collect(Collectors.toList());
        //锁表
        List<TbItem> tbItemList=tbItemMapper.selectStockForUpdate(ids);
        if(tbItemList==null||tbItemList.isEmpty()){
            throw new BizException("未找到对应的商品");
        }
        if (ids.size()!=tbItemList.size()){
            throw  new BizException("部分商品不存在");
        }
        //循环便利
        itemStockDos.forEach(itemStockDo -> {
            tbItemList.forEach(item -> {
                if(Objects.equals(item.getId(),itemStockDo.getItemId())){
                    if(item.getNum()<itemStockDo.getNum()){
                        throw new BizException(itemStockDo.getItemId()+":库存不足");
                    }
                }
                TbItem tbItem=new TbItem();
                tbItem.setId(itemStockDo.getItemId());
                tbItem.setNum(itemStockDo.getNum());
                //扣减库存
                int row=tbItemMapper.decreaseStock(tbItem);
                if(row<=0){
                    throw new BizException(itemStockDo.getItemId()+"库存不足");
                }
                return;
            });
        });
        return true;
    }
}
