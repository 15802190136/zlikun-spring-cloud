# zlikun-spring-cloud-04-consumer-feign

#### 启用`feign`
```
# 引入依赖
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-feign</artifactId>
</dependency>

# 启动类上配置注解 @EnableFeignClients ，否则无法激活 @FeignClient 注解

# 声明一个接口实现接口，使用 @FeignClient 注解标记，参数指定服务提供者名称

# 直接使用 @Autowired 注入即可使用

# 如果要替换默认 HttpClient 实现，可引入
<!-- 使用 OkHttp 替换 feign 的默认 httpClient 实现，也可以使用 HttpComponents 组件实现 -->
<dependency>
    <groupId>com.netflix.feign</groupId>
    <artifactId>feign-okhttp</artifactId>
    <version>8.18.0</version>
</dependency>
```

#### 多参数请求
```
# 使用实体参数，即使指定为 GET 请求，也会被当成 POST 请求来处理，并且会抛出 405 状态码
@RequestMapping(value = "create" ,method = RequestMethod.GET)
void create(User user) ;

# 解决方法一：把字段拆出，做为方法参数使用
# 解决方法二：把参数包装成一个Map即可
@RequestMapping(value = "create" ,method = RequestMethod.GET)
void create(Map<String ,Object> user) ;

```
