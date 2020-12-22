package com.xue.example.springcloudmallusersserver9095.biz;


import com.xue.example.springcloudmallusersserver9095.dto.AuthLoginDto;
import com.xue.example.springcloudmallusersserver9095.enums.LoginTypeEnum;
import com.xue.example.springcloudmallusersserver9095.mapper.entitys.TbMember;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class PhoneCodeLoginProcessor extends AbstractLogin{
    @Override
    public int getLoginType() {
        return LoginTypeEnum.PHONE_CODE.getCode();
    }
    @Override
    public void validate(AuthLoginDto authLoginDto) {
        if(StringUtils.isBlank(authLoginDto.getPhone())){
            //TODO
        }
    }

    @Override
    public TbMember doProcessor(AuthLoginDto authLoginDto) {
        return null;
    }
}
