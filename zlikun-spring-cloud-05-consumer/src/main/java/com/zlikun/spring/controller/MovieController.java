package com.zlikun.spring.controller;

import com.zlikun.spring.feign.UserFeignClient;
import com.zlikun.spring.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/7/17 10:11
 */
@RestController
public class MovieController {

    private Logger logger = LoggerFactory.getLogger(MovieController.class) ;

    @Autowired
    private UserFeignClient userFeignClient;

//    /**
//     * 当服务端不可用时，将执行 findByIdFallback 方法 <br>
//     * 实际上当请求失败、被拒绝、超时或者断路器打开时，都会进入回退方法，这里并不能直接识别出是断路器打开造成的回退操作 <br>
//     * actuator 组件打开时，/health 端点可以看到断路器状态<br>
//     * 当服务提供者宕机时，断路器的状态仍是 UP ，直到失败率达到阈值(默认：5秒内20次失败)，才会变更状态 CIRCUIT_OPEN (断路器打开)
//     * @param id
//     * @return
//     */
//    @HystrixCommand(fallbackMethod = "findByIdFallback" ,commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,value = "5000") ,
//            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds" ,value = "10000")
//    } ,threadPoolProperties = {
//            @HystrixProperty(name = "coreSize" ,value = "1") ,
//            @HystrixProperty(name = "maxQueueSize" ,value = "10")
//    })
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id) ;
    }

//    /**
//     * findById 的 fallback 方法，由 @HystrixCommand(fallbackMethod = "findByIdFallback") 设置
//     * @param id
//     * @return
//     */
//    public User findByIdFallback(@PathVariable Long id) {
//        logger.info("执行[findById]失败回调，参数：{}" ,id);
//        User user = new User() ;
//        user.setId(-1L);
//        user.setName("默认用户");
//        return user ;
//    }

}
