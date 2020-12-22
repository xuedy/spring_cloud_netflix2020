package com.xue.example.springclouduserserver9091.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@DefaultProperties(defaultFallback = "fallback")
@RestController
public class HystrixDemoController {
    @Autowired
    RestTemplate restTemplate;
    //熔断配置
    //hysrix 的降级的触发
    // 1.熔断
         //熔断是实现服务降级的前提条件
    // 2.超时
    // 3.自资源隔离
    /**
     *   默认：10秒内发起20次请求，失败率超过50%，熔断5秒
     *  次段时间，不发送请求
     *  熔断会有一个自动恢复
     *  circuitBreaker.enabled 开启
     *  circuitBreaker.requestVolumeThreshold 最下请求次数
     *  circuitBreaker.sleepWindowInMilliseconds 熔断时间
     *  circuitBreaker.errorThresholdPercentage 异常率
     *  熔断会触发回退方法 fallbackMethod
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "5"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50")
    },
            fallbackMethod = "fallback")
    @GetMapping("/hystrix/all/{num}")
    public String getOrders(@PathVariable("num") int num){
        if(num%2==0){
            return "OK";
        }
        System.out.println("触发调用");
       return  restTemplate.getForObject("http://10.0.61.161:9090/orders",String.class);
    }

    /**
     * 超时请求触发降级
     * 默认1秒钟
     * @param num
     * @return
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    },
            fallbackMethod = "fallbackTimeOut")
    @GetMapping("/hystrix/query/{num}")
    public String queryTimeOut(@PathVariable("num") int num){
        if(num%2==0){
            return "OK";
        }
        System.out.println("触发调用");
        return  restTemplate.getForObject("http://10.0.61.161:9090/orders",String.class);
    }
    //兜底数据
    private String fallback(int num){
        return "系统繁忙";
    }

    private String fallbackTimeOut(int num){
        return "请求超时";
    }
}
