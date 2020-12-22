package com.xue.proposal.clients;

import com.xue.proposal.ProductTypeConfigService;
import com.xue.proposal.dto.ProductTypeConfigDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "proposal-config-service",fallback =ProductTypeFeignClient.FeignClientFallBack.class )
public interface ProductTypeFeignClient extends ProductTypeConfigService {
    //被spring加载
    @Component
    class FeignClientFallBack implements  ProductTypeFeignClient{

      @Override
      public String orders() {
          return "失败";
      }

      @Override
      public int insert(ProductTypeConfigDto productTypeConfigDto) {
          return -1;
      }
  }
}
