package com.xue.example.goodsservice.service.impl;

import com.xue.example.goodsservice.mapper.entitys.TbItemCat;
import com.xue.example.goodsservice.mapper.entitys.TbItemCatExample;
import com.xue.example.goodsservice.mapper.persistence.TbItemCatMapper;
import com.xue.example.goodsservice.service.ITbItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbItemCatImpl implements ITbItemCatService {
    @Autowired
    TbItemCatMapper tbItemCatMapper;
    @Override
    public TbItemCat getGoods(Long id) {
        return tbItemCatMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbItemCat> findItemsByIds(List<Long> ids) {
        TbItemCatExample example=new TbItemCatExample();
        example.createCriteria().andIdIn(ids);
        return tbItemCatMapper.selectByExample(example);
    }
}
