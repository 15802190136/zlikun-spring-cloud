# zlikun-spring-cloud

基于 `spring-cloud` + `sping-boot` 构建微服务，关于`spring-cloud`更多信息参考：[官网](http://projects.spring.io/spring-cloud/)

#### Modules
- 01 工程组，简单基于spring-cloud实现的服务提供者、消费者示例
- 02 工程组，引入eureka用于注册、发现服务，配置eureka开启认证
- 03 工程组，测试多个eureka构成集群工作情况，测试eureka的REST API
- 04 工程组，测试基于Ribbon实现的负载均衡(配合eureka)，消费者使用Feign实现声明式REST调用
- 05 工程组，测试Hystrix实现微服务容错处理

#### Actuator
> Spring Boot Actuator 提供了很多监控端点，可以使用REST API来访问这些端点，以了解应用程序运行情况。

实现该功能需要引入如下依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

常用 Actuator 端点及描述

| 端点 | 描述 | HTTP方法 |
| --- | --- | --- |
| autoconfig | 显示自动配置的信息 | GET |
| beans | 显示应用程序上下文所有的Spring Bean | GET |
| configprops | 显示所有 @ConfigurationProperties的配置属性列表 | GET |
| dump | 显示线程活动的快照 | GET |
| env | 显示应用的环境变量 | GET |
| health | 显示应用程序的健康指标，这些值由 HealthIndicator 的实现类提供 | GET |
| info | 显示应用的信息，可以使用 info.* 属性自定义 info 端点公开的数据 | GET |
| mappings | 显示所有的URL路径 | GET |
| metrics | 显示应用的度量标准信息 | GET |
| trace | 显示跟踪信息(默认最近100个HTTP请求) | GET |
| shutdown | 关闭应用(默认情况不启用，如需启用，需设置 endpoints.shutdown.enabled=true) | POST |

开启 autoconfig 配置
```
management:
  security:
    enabled: false
```

开启 info 配置
```
info:
  app:
    name: @project.artifactId@
    encoding: @project.build.sourceEncoding@
    java:
      source: @java.version@
      target: @java.version@
```

#### Eureka
> Eureka是Netflix开源的服务发现组件，本身是一个基于REST的服务，包含Server和Client两部分。Spring Cloud将它集成在子项目Spring Cloud Netflix中，从而实现微服务的注册与发现。  
- Eureka Server提供服务发现的能力，各个微服务启动时，会向Eureka Server注册自己的信息(IP、端口、服务名称等)，Eureka Server会存储这些信息。  
- Eureka Client是一个Java客户端，用于简化与Eureka Server的交互。微服务启动后，会周期性(默认30秒)地向Eureka Server发送心跳以续约自己的"租期"。如果Eureka Server在一定时间内没有接收到某个微服务实例的心跳，Eureka Server会注销该实例(默认90秒)。
- 默认情况下，Eureka Server同时也是Eureka Client，多个Eureka Server实例，互相之间通过复制的方式，来实现服务注册表中数据同步。
- Eureka Client会缓存服务注册表的信息，这种方式下，微服务不用每次都查询Eureka Server，从而降低Eureka Server的压力，而且即使Eureka Server节点都宕掉，服务消费者依然可以使用缓存中的信息找到服务提供者并完成调用。

