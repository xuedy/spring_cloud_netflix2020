package com.xue.example.feignclients;

import com.xue.example.dto.GoodsDto;
import com.xue.example.service.IGoodsService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "openfeign-demo-server-service-9093",fallback =GoodsServiceFeignClient.GoodsServiceFeignClientFallBack.class )
public interface GoodsServiceFeignClient extends IGoodsService {

    @Component
    class GoodsServiceFeignClientFallBack implements GoodsServiceFeignClient{
        @Override
        public String getGoods() {
            return "失败";
        }

        @Override
        public int addGoods(GoodsDto goodsDto) {
            return -1;
        }
    }
}
