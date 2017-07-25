# zlikun-spring-cloud-05-turbine

#### Turbine聚合监控
> HystrixDashboard只能监控一个实例，微服务通常由一组实例构成，可以使用Turbine将其聚合监控。
```
# 添加依赖
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-turbine</artifactId>
</dependency>

# 启动类上添加 @EnableTurbine 注解

# application.yml 增加配置
# turbine.app-config 可配置多个微服务实例，中间以逗号隔开，表示聚合多个微服务
turbine:
  app-config: microservice-consumer-user
  cluster-name-expression: "'default'"
  
# http://localhost:8010/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8010%2Fturbine.stream
```