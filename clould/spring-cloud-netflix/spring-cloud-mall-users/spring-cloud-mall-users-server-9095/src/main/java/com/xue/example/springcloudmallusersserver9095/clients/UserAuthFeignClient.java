package com.xue.example.springcloudmallusersserver9095.clients;

import com.xue.example.api.R;
import com.xue.example.clients.IUserAuthFeignClient;
import com.xue.example.exception.ValidException;
import com.xue.example.springcloudmallusersserver9095.utils.JwtGeneratorUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthFeignClient implements IUserAuthFeignClient {
    @Override
    public R<String> validToken(String token) {
        if(StringUtils.isEmpty(token)){
            throw new ValidException("token为空");
        }
        try {
            Claims claims = JwtGeneratorUtil.parseToken(token);
            return new R.Builder().setData(claims.get("uid").toString()).buildOK();
        }catch (ExpiredJwtException e){
            return new R.Builder().buildCustomize("token已过期");
        }catch (SignatureException e){
            return new R.Builder().buildCustomize("签名校验失败");
        }
    }
}
