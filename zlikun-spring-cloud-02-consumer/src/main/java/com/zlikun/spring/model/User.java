package com.zlikun.spring.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户实体
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/7/17 10:07
 */
@Data
public class User {

    private Long id ;
    private String username ;
    private String name ;
    private Integer age ;
    private BigDecimal balance ;

}
