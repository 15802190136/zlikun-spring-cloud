# zlikun-spring-cloud

基于 `spring-cloud` + `sping-boot` 构建微服务，关于`spring-cloud`更多信息参考：[官网](http://projects.spring.io/spring-cloud/)

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