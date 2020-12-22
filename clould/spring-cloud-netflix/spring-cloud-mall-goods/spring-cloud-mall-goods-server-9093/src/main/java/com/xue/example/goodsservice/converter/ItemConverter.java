package com.xue.example.goodsservice.converter;

import com.xue.example.dto.ItemStockDto;
import com.xue.example.goodsservice.domain.ItemStockDo;
import com.xue.example.goodsservice.mapper.entitys.TbItem;
import com.xue.example.goodsservice.mapper.entitys.TbItemCat;
import com.xue.example.vo.ItemDetailVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemConverter {
    @Mappings({})
    ItemDetailVo tbItemDetail2Vo(TbItem tbItem);

    List<ItemDetailVo> itemDetail2VoList(List<TbItem> tbItemList);

    @Mappings({})
    ItemStockDo ItemStockDto2toVo(ItemStockDto itemStockDto);

    List<ItemStockDo>   itemStockDo2DoList(List<ItemStockDto> itemStockDtos);
}
