package com.xue.example.orderservice.converter;


import com.xue.example.dto.ItemStockDto;
import com.xue.example.orderservice.dto.ItemsDto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderConverter {

    ItemStockDto itemDtoStockDto(ItemsDto itemsDto);

    List<ItemStockDto> itemsDto2StockDtoList(List<ItemsDto> itemsDtos);
}
