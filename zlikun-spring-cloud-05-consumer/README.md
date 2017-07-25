# zlikun-spring-cloud-05-consumer

#### Hystrix
> Hystrix 隔离策略有两种：线程隔离和信号量隔离

- THREAD (线程隔离)：使用该方式(默认且推荐)，HystrixCommand将会在单独的线程上执行，并发请求受线程池中线程数量限制。这种方式有一个除网络超时以外的额外保护层。
- SEMAPHORE (信号量隔离)：使用该方式，HystrixCommand将会在调用线程上执行，开销相对较小，并发请求受到信号量个数限制。只有当调用负载非常高时(如：每个实例每秒调用数百次)才需要使用信号量隔离，一般仅适用于非网络调用的隔离。

#### 配置
- 与@RequestMapping 配合使用
```
/**
 * 当服务端不可用时，将执行 findByIdFallback 方法 <br>
 * 实际上当请求失败、被拒绝、超时或者断路器打开时，都会进入回退方法，这里并不能直接识别出是断路器打开造成的回退操作 <br>
 * actuator 组件打开时，/health 端点可以看到断路器状态<br>
 * 当服务提供者宕机时，断路器的状态仍是 UP ，直到失败率达到阈值(默认：5秒内20次失败)，才会变更状态 CIRCUIT_OPEN (断路器打开)
 * @param id
 * @return
 */
@HystrixCommand(fallbackMethod = "findByIdFallback" ,commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,value = "5000") ,
        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds" ,value = "10000")
} ,threadPoolProperties = {
        @HystrixProperty(name = "coreSize" ,value = "1") ,
        @HystrixProperty(name = "maxQueueSize" ,value = "10")
})
@GetMapping("/user/{id}")
public User findById(@PathVariable Long id) {
    return userFeignClient.findById(id) ;
}

/**
 * findById 的 fallback 方法，由 @HystrixCommand(fallbackMethod = "findByIdFallback") 设置
 * @param id
 * @return
 */
public User findByIdFallback(@PathVariable Long id) {
    logger.info("执行[findById]失败回调，参数：{}" ,id);
    User user = new User() ;
    user.setId(-1L);
    user.setName("默认用户");
    return user ;
}
```

- Feign使用Hystrix
> spring-cloud 默认已为Feign整合了Hystrix，只要Hystrix在项目的classpath中，Feign默认就会用断路器包裹所有方法。

```
@FeignClient(name = "microservice-provider-user" ,fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id) ;

}

/**
 * 由于Feign接口只有接口没有实现，所以这里需要一个Fallback的实现
 */
 @Component
public class UserFeignClientFallback implements UserFeignClient {
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
```

#### 监控
```
# http://localhost:8010/hystrix.stream

ping: 

data: {"type":"HystrixCommand","name":"findById","group":"MovieController","currentTime":1500982601002,"isCircuitBreakerOpen":false,"errorPercentage":0,"errorCount":0,"requestCount":0,"rollingCountBadRequests":0,"rollingCountCollapsedRequests":0,"rollingCountEmit":0,"rollingCountExceptionsThrown":0,"rollingCountFailure":0,"rollingCountFallbackEmit":0,"rollingCountFallbackFailure":0,"rollingCountFallbackMissing":0,"rollingCountFallbackRejection":0,"rollingCountFallbackSuccess":0,"rollingCountResponsesFromCache":0,"rollingCountSemaphoreRejected":0,"rollingCountShortCircuited":0,"rollingCountSuccess":0,"rollingCountThreadPoolRejected":0,"rollingCountTimeout":0,"currentConcurrentExecutionCount":0,"rollingMaxConcurrentExecutionCount":0,"latencyExecute_mean":0,"latencyExecute":{"0":0,"25":0,"50":0,"75":0,"90":0,"95":0,"99":0,"99.5":0,"100":0},"latencyTotal_mean":0,"latencyTotal":{"0":0,"25":0,"50":0,"75":0,"90":0,"95":0,"99":0,"99.5":0,"100":0},"propertyValue_circuitBreakerRequestVolumeThreshold":20,"propertyValue_circuitBreakerSleepWindowInMilliseconds":5000,"propertyValue_circuitBreakerErrorThresholdPercentage":50,"propertyValue_circuitBreakerForceOpen":false,"propertyValue_circuitBreakerForceClosed":false,"propertyValue_circuitBreakerEnabled":true,"propertyValue_executionIsolationStrategy":"THREAD","propertyValue_executionIsolationThreadTimeoutInMilliseconds":5000,"propertyValue_executionTimeoutInMilliseconds":5000,"propertyValue_executionIsolationThreadInterruptOnTimeout":true,"propertyValue_executionIsolationThreadPoolKeyOverride":null,"propertyValue_executionIsolationSemaphoreMaxConcurrentRequests":10,"propertyValue_fallbackIsolationSemaphoreMaxConcurrentRequests":10,"propertyValue_metricsRollingStatisticalWindowInMilliseconds":10000,"propertyValue_requestCacheEnabled":true,"propertyValue_requestLogEnabled":true,"reportingHosts":1,"threadPool":"MovieController"}

... ...

# 启动类上添加 @EnableHystrixDashboard 注解，激活HystrixDashboard功能
# 使用之前需添加依赖
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>

# http://localhost:8010/hystrix
# http://localhost:8010/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8010%2Fhystrix.stream
```