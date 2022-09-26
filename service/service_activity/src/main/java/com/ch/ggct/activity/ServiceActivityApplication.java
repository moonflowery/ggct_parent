package com.ch.ggct.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月25日 22:43
 */
@ComponentScan(basePackages = "com.ch")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.ch")
public class ServiceActivityApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceActivityApplication.class,args);
    }
}
