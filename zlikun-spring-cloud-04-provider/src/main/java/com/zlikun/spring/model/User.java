package com.zlikun.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 用户实体
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/7/17 9:40
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column
    private String username ;

    @Column
    private String name ;

    @Column
    private Integer age ;

    @Column
    private BigDecimal balance ;

}
