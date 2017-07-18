package com.zlikun.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// 使用 @EnableDiscoveryClient 注解，声明这是一个Eureka Client，推荐使用
// 也可以用 @EnableEurekaClient 代替，表明是一个Eureka Client，@EnableDiscoveryClient 是一个抽象，针对各个服务发现组件，如：Zookeeper、Consul等
// 启动Eureka Client前，Eureka Server服务必须存在，否则启动报错
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}
}
