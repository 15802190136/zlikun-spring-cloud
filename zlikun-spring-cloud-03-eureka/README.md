# zlikun-spring-cloud-03-eureka

通过profile模似集群部署

#### 启动集群节点
```
$ java -jar eureka.jar --spring.profiles.active=peer1
$ java -jar eureka.jar --spring.profiles.active=peer2
```