//package com.zlikun.spring.ribbon;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import com.netflix.loadbalancer.RoundRobinRule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 该类通常不应被应用的@ComponentScan包含，否则其将影响所有的RibbonClient
// * @auther zlikun <zlikun-dev@hotmail.com>
// * @date 2017/7/21 9:19
// */
//@Configuration
//public class RibbonConfiguration {
//
//    /**
//     * 配置负载均衡策略(规则)
//     * @return
//     */
//    @Bean
//    public IRule ribbonRule() {
////        // 设置为轮询策略
////        return new RoundRobinRule() ;
//        // 设置为随机策略
//        return new RandomRule() ;
//    }
//
//}
