# zlikun-spring-cloud-06-provider

模拟多台服务，将工程打包，使用命令行启动
```
$ mvn clean package

target >
$ java -jar zlikun-spring-cloud-06-provider-1.0.0.jar --server.port=9010
$ java -jar zlikun-spring-cloud-06-provider-1.0.0.jar --server.port=9020
```