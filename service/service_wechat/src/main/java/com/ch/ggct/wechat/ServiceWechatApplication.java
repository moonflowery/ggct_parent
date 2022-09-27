package com.ch.ggct.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月26日 10:10
 */

@MapperScan(basePackages = "com.ch.ggct.wechat.mapper")
@ComponentScan(basePackages = "com.ch")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.ch")
public class ServiceWechatApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceWechatApplication.class,args);


    }
}
