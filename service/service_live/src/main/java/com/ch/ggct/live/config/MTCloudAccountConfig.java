package com.ch.ggct.live.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年10月03日 16:56
 */
@Data
@Component
@ConfigurationProperties(prefix = "mtcloud")
public class MTCloudAccountConfig {

        private String openId;
        private String openToken;

    }

