package com.study.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiaxiao.
 * @date 2021/11/22.
 * @time 16:08
 */
@Configuration
public class ConfigBean {


    /*注册RestTemplate*/
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

