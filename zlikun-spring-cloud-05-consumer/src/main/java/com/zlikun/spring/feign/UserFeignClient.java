package com.zlikun.spring.feign;

import com.zlikun.spring.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/7/24 9:16
 */
@FeignClient(name = "microservice-provider-user" ,fallback = UserFeignClient.UserFeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id) ;

    /**
     * 由于Feign接口只有接口没有实现，所以这里需要一个Fallback的实现
     */
    static class UserFeignClientFallback implements UserFeignClient {

        Logger logger = LoggerFactory.getLogger(this.getClass()) ;

        @Override
        public User findById(Long id) {
            logger.info("执行[findById]失败回调，参数：{}" ,id);
            User user = new User() ;
            user.setId(-1L);
            user.setName("默认用户");
            return user ;
        }

    }

}
