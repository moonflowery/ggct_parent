package com.ch.ggct.service_vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月11日 22:48
 */
@EnableSwagger2
@SpringBootApplication
public class ServiceVodApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }
}
