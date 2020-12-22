package com.xue.example.clients;

import com.xue.example.api.R;
import com.xue.example.dto.ItemStockDto;
import com.xue.example.vo.ItemDetailVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;
import java.util.List;

@FeignClient(value = "mall-goods-server-9093")
public interface IGoodsFeignClient {

/**
 * 锁定并扣减库存
 */
@PutMapping(value="/items/stock",consumes = MediaType.APPLICATION_JSON_VALUE)
R decreaseStock(@RequestBody List<ItemStockDto> itemStockDtos);
/**
 * 根据id查询商品列表
 */
@GetMapping("/items/{ids}")
R<List<ItemDetailVo>> getItemsByIds(@PathVariable List<Long> ids);

}
