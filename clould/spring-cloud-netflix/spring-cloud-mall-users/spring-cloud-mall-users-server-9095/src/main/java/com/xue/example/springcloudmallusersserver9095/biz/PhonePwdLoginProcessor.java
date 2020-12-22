package com.xue.example.springcloudmallusersserver9095.biz;

import com.xue.example.springcloudmallusersserver9095.dto.AuthLoginDto;
import com.xue.example.springcloudmallusersserver9095.enums.LoginTypeEnum;
import com.xue.example.springcloudmallusersserver9095.mapper.entitys.TbMember;
import org.springframework.stereotype.Service;


@Service
public class PhonePwdLoginProcessor extends AbstractLogin{
    @Override
    public int getLoginType() {
        return LoginTypeEnum.PHONE_PWD.getCode();
    }

    @Override
    public void validate(AuthLoginDto authLoginDto) {

    }

    @Override
    public TbMember doProcessor(AuthLoginDto authLoginDto) {
        return null;
    }
}
