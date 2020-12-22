package com.xue.example.clients;

import com.xue.example.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-server-9095")
public interface IUserAuthFeignClient {
    @GetMapping(value = "/token",consumes = MediaType.APPLICATION_JSON_VALUE)
    R<String> validToken(@RequestParam("token") String token);
}
