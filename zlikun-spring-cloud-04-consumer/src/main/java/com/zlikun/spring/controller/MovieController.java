package com.zlikun.spring.controller;

import com.zlikun.spring.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/7/17 10:11
 */
@RestController
public class MovieController {

    private Logger logger = LoggerFactory.getLogger(MovieController.class) ;

    /**
     * RestTemplate 用于请求 REST API并解析其返回值
     */
    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private LoadBalancerClient loadBalancerClient ;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        // microservice-provider-user 是微服务的虚拟主机名，配置Ribbon和Eureka将虚拟主机名自动映射成微服务网络地址
        // 不能将restTemplate.getForObject() 与 loadBalancerClient.choose() 写在同一个方法中，两者之间有冲突，restTemplate本身是一个Ribbon客户端，已隐式包含了choose行为
        return restTemplate.getForObject("http://microservice-provider-user/" + id ,User.class) ;
    }

    @GetMapping("/log-instance")
    public String showInfo() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user") ;
        return String.format("选择节点 [%s:%s:%d]" ,serviceInstance.getServiceId() ,serviceInstance.getHost() ,serviceInstance.getPort());
    }

}
