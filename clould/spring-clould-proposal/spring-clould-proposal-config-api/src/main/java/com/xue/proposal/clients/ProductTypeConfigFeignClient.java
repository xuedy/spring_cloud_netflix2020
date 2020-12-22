package com.xue.proposal.clients;

import com.xue.proposal.ProductTypeConfigService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("xue-service-order-test")
public interface ProductTypeConfigFeignClient extends ProductTypeConfigService {
}
