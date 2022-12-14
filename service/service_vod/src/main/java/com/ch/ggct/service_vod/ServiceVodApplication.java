package com.ch.ggct.service_vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月11日 22:48
 */
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ServiceVodApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }
}
