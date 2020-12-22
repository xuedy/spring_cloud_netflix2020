package com.xue.example.springclouduserserver9091.registrar;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

public class MyPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        System.out.println("isAlive"+server.getHost()+":"+server.getPort());
        return false;
    }
}
