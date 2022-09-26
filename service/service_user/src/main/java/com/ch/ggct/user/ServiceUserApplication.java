package com.ch.ggct.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月25日 17:09
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ch.ggct.user.mapper")
public class ServiceUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class,args);
    }
}
