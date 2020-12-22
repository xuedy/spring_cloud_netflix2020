package com.xue.proposal.springclouldproposalconfigserver.service;

import com.xue.proposal.ProductTypeConfigService;
import com.xue.proposal.dto.ProductTypeConfigDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductTypeConfigServiceImpl implements ProductTypeConfigService {
    @Override
    public String orders() {
        return "Return All Orders";
    }

    @Override
    public int insert(ProductTypeConfigDto dto) {
        return 0;
    }
}
