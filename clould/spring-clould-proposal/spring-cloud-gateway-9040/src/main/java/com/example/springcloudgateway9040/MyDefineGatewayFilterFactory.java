package com.example.springcloudgateway9040;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义Filter
 */
@Component
public class MyDefineGatewayFilterFactory extends AbstractGatewayFilterFactory<MyDefineGatewayFilterFactory.MyConfig> {

    private static final String NAME_KEY="name";
    Logger logger= LoggerFactory.getLogger(MyDefineGatewayFilterFactory.class);
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(NAME_KEY);
    }

    public MyDefineGatewayFilterFactory() {
        super(MyConfig.class);
    }

    @Override
    public GatewayFilter apply(MyConfig config) {
        return ((exchange, chain) -> {
            //TUDO 拦截到请求的操作
            logger.info("[pre] Filter Request ,name :{}",config.getName());
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                //TUDO返回之前的操作
                logger.info("[post] Filter Response ");
            }));
        });
    }

    public static class MyConfig{
     private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
