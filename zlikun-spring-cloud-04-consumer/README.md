# zlikun-spring-cloud-04-consumer

#### 自定义Ribbon配置
- 负载均衡策略配置
```java
/**
 * 配置负载均衡策略(规则)
 * @return
 */
@Bean
public IRule ribbonRule() {
    // 设置为轮询策略
    // return new RoundRobinRule() ;
    // 设置为随机策略
    return new RandomRule() ;
}
```