package com.ch.ggct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月25日 01:43
 */
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.ch")
public class ServiceOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class,args);
    }
}
