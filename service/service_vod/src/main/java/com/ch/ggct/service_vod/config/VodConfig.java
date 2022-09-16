package com.ch.ggct.service_vod.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月11日 22:50
 */
@Configuration
@MapperScan("com.ch.ggct.service_vod.mapper")
public class VodConfig {
    /*
     *分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}
