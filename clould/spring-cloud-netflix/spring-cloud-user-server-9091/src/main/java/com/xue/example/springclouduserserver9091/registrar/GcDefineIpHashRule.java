package com.xue.example.springclouduserserver9091.registrar;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class GcDefineIpHashRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return this.choose(getLoadBalancer(),o);
    }
    public Server choose(ILoadBalancer lb, Object key){
        if (lb == null) {
            return null;
        }
        Server server = null;
        while(server==null){
            List<Server> allList=lb.getAllServers();
            System.out.println(allList);
            int index=0;
            server=allList.get(index);
        }
        return server;
    }
}
