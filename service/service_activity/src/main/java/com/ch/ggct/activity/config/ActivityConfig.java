package com.ch.ggct.activity.config;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月25日 23:43
 */
@Configuration
@MapperScan("com.ch.ggct.activity.mapper")
public class ActivityConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
