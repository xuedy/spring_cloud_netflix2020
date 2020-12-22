package com.xue.example.springcloudmallusersserver9095.biz;


import com.xue.example.exception.BizException;
import com.xue.example.exception.ValidException;
import com.xue.example.springcloudmallusersserver9095.dto.AuthLoginDto;
import com.xue.example.springcloudmallusersserver9095.enums.LoginTypeEnum;
import com.xue.example.springcloudmallusersserver9095.mapper.entitys.TbMember;
import com.xue.example.springcloudmallusersserver9095.mapper.entitys.TbMemberExample;
import com.xue.example.springcloudmallusersserver9095.mapper.persistence.TbMemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;


@Slf4j
@Service
public class NormalLoginProcessor extends AbstractLogin{

    @Autowired
    TbMemberMapper tbMemberMapper;

    @Override
    public int getLoginType() {
        return LoginTypeEnum.NORMAL.getCode();
    }

    @Override
    public void validate(AuthLoginDto authLoginDto) {
        if(StringUtils.isBlank(authLoginDto.getUsername())||StringUtils.isBlank(authLoginDto.getPassword())){
            throw new ValidException("帐号或者密码不能为空");
        }
    }

    @Override
    public TbMember doProcessor(AuthLoginDto authLoginDto) {
        log.info("begin NormalLoginProcessor.doProcessor:"+authLoginDto);
        TbMemberExample tbMemberExample=new TbMemberExample();
        tbMemberExample.createCriteria().andStateEqualTo(1).andUsernameEqualTo(authLoginDto.getUsername());
        List<TbMember> members=tbMemberMapper.selectByExample(tbMemberExample);
        if(members==null||members.size()==0){
            throw new BizException("用户名或者密码错误");
        }
        if(!DigestUtils.md5DigestAsHex(authLoginDto.getPassword().getBytes()).equals(members.get(0).getPassword())){
            throw new BizException("用户名或者密码错误");
        }
        return members.get(0);
    }
}
