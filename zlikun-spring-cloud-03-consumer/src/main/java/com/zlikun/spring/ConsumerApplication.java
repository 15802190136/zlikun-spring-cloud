package com.zlikun.spring;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/7/17 10:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate() ;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class ,args) ;
    }

}
