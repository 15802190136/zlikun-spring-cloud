package com.zlikun.spring.controller;

import com.zlikun.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    RestTemplate restTemplate ;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        // 这里调用的是zuul网关地址，测试发现zuul也可以实现负载均衡(Ribbon)
        return restTemplate.getForObject("http://localhost:8000/microservice-provider-user/1" ,User.class) ;
    }

}
