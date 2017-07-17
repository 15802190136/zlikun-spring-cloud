package com.zlikun.spring.dao;

import com.zlikun.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/7/17 9:43
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {



}
