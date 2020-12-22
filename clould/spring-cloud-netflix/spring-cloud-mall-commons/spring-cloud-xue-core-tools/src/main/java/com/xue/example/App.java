package com.xue.example;

import com.xue.example.common.utils.SnowFlakeGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws InterruptedException {
        SnowFlakeGenerator snowFlakeGenerator = new SnowFlakeGenerator(1, 1, 1);
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1);
            System.out.println(snowFlakeGenerator.nextVal());
        }
    }
}
