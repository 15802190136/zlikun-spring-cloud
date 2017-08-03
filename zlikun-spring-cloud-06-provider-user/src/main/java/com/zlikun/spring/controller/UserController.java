package com.zlikun.spring.controller;

import com.zlikun.spring.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/7/17 9:44
 */
@Slf4j
@RestController
public class UserController {

    String uuid = UUID.randomUUID().toString() ;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        log.info("在 {} 节点上查询ID为{}的数据!" ,uuid ,id);
        // Mock User Data
        if(id > 10) return null ;
        User user = new User() ;
        user.setId(id);
        user.setName("用户-" + id);
        user.setBalance(new BigDecimal(id * 1000));
        user.setAge(id.intValue() + 18);
        user.setUsername("user-" + id);
        return user ;
    }

}
