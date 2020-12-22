package com.xue.example.springcloudorderserver9090.controller.order;

import com.xue.example.api.R;
import com.xue.example.springcloudorderserver9090.dto.OrderDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping("order")
    public R order(@RequestBody @Validated OrderDto orderDto, BindingResult bindingResult){
          orderDto.validData(bindingResult);
         return new R.Builder<>().buildOK();
    }
}
