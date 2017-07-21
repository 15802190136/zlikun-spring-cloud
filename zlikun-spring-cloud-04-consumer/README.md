# zlikun-spring-cloud-04-consumer

#### 自定义Ribbon配置

```
// 针对 `microservice-provider-user` 服务，使用 RibbonConfiguration 配置
@RibbonClient(name = "microservice-provider-user" ,configuration = RibbonConfiguration.class)
```

- 负载均衡策略配置(Java)

```
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

- Ribbon配置(配置文件)
```
# application.yml

# 配置指定服务的负载均衡策略
microservice-provider-user:
  ribbon:
    # 随机
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
    # 轮询(默认)
    # NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RoundRobinRule
    
# 其它可选配置
NFLoadBalancerClassName：配置ILoadBalancer的实现类
NFLoadBalancerRuleClassName：配置IRule的实现类
NFLoadBalancerPingClassName：配置IPing的实现类
NIWSServerListClassName：配置ServerList的实现类
NIWSServerListFilterClassName：配置ServerListFilter的实现类
```