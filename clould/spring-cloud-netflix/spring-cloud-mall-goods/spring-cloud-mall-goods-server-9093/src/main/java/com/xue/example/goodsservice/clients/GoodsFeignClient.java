package com.xue.example.goodsservice.clients;

import com.xue.example.api.R;
import com.xue.example.clients.IGoodsFeignClient;
import com.xue.example.dto.ItemStockDto;
import com.xue.example.goodsservice.converter.ItemConverter;
import com.xue.example.goodsservice.domain.ItemStockDo;
import com.xue.example.goodsservice.mapper.entitys.TbItem;
import com.xue.example.goodsservice.mapper.entitys.TbItemCat;
import com.xue.example.goodsservice.service.IItemService;
import com.xue.example.goodsservice.service.ITbItemCatService;
import com.xue.example.vo.ItemDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class GoodsFeignClient implements IGoodsFeignClient {

    @Autowired
    ITbItemCatService iTbItemCatService;
    @Autowired
    IItemService iItemService;

    @Autowired
    ItemConverter itemConverter;
    @Override
    public R decreaseStock(List<ItemStockDto> itemStockDtos) {
        log.info("decreaseStock 开始：{}",itemStockDtos);
        List<ItemStockDo> itemStockDos =itemConverter.itemStockDo2DoList(itemStockDtos);
        boolean rs=iItemService.decreaseStock(itemStockDos);

        return new R.Builder<Boolean>().setData(rs).buildOK();
    }


    @Override
    public R<List<ItemDetailVo>> getItemsByIds(List<Long> ids) {
        log.info("开始 getItemsByIds：{}",ids);
        List<TbItem> list=iItemService.findItemsByIds(ids);
        List<ItemDetailVo> itemDetailVos=itemConverter.itemDetail2VoList(list);
        return  new R.Builder<List<ItemDetailVo>>().setData(itemDetailVos).buildOK();
    }
}
