package com.zlikun.spring.controller;

import com.zlikun.spring.dao.UserDao;
import com.zlikun.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/7/17 9:44
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao ;

    /**
     * @GetMapping Spring-4.3提供的新注解，顾名思义，等价于 @RequestMapping(method = RequestMethod.GET) <br>
     * 主键查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userDao.findOne(id) ;
    }

}
