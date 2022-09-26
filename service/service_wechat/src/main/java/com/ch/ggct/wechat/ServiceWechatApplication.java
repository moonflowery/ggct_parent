package com.ch.ggct.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月26日 10:10
 */


@SpringBootApplication
@MapperScan(basePackages = "com.ch.ggct.wechat.mapper")
public class ServiceWechatApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceWechatApplication.class,args);


    }
}
