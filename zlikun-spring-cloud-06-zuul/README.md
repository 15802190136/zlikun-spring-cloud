# zlikun-spring-cloud-06-zuul

#### 依赖
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zuul</artifactId>
</dependency>
```

#### 路由
```
# 需配置 management.security.enabled=false 方能访问
$ curl http://localhost:8000/routes

{
"/microservice-provider-user/**": "microservice-provider-user",
"/microservice-consumer-user/**": "microservice-consumer-user"
}
```
