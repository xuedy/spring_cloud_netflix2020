package com.xue.proposal;

import com.xue.proposal.dto.ProductTypeConfigDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface ProductTypeConfigService {

    @GetMapping("/orders")
    String orders();

    @PostMapping("/order")
    int insert(ProductTypeConfigDto dto);
}
