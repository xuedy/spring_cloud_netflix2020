package com.xue.example.springcloudgateway8080;


import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义 断言
 */
@Component
public class AuthRoutePredicateFactory  extends AbstractRoutePredicateFactory<AuthRoutePredicateFactory.Config> {
    private static final String NAME_KEY="name";
    private static final String VALUE_KEY="value";

    public AuthRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return  Arrays.asList(NAME_KEY,VALUE_KEY);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return (exchange->{
            //Header中携带了某个值，进行header的判断
            HttpHeaders httpHeaders= exchange.getRequest().getHeaders();
            List<String> headerList=httpHeaders.get(config.getName());
            return headerList.size()>0;
        });
    }

    public static class Config{
        private String name;
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
