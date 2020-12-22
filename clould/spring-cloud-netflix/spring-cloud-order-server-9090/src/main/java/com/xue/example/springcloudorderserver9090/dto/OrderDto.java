package com.xue.example.springcloudorderserver9090.dto;

import com.xue.example.exception.ValidException;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class OrderDto {
    @NotNull(message = "name 不能为空")
    private String name;
    @NotNull(message = "tel 不能为空")
    private String tel;
    private String userId;
    @NotEmpty(message = "商品明细不能为空")
    private List<ItemDto> items;

    public void validData(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder stringBuilder=new StringBuilder();
            for (ObjectError objectError:bindingResult.getAllErrors()) {
                stringBuilder.append(objectError.getDefaultMessage()+"\n");
            }
              throw new ValidException(stringBuilder.toString());
        }
    }
}
