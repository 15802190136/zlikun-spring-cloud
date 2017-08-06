FROM docker.io/java
MAINTAINER zlikun <zlikun-dev@hotmail.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "~/studio/server/eureka/eureka.jar"]

# spring-boot 打包时将依赖已打入，所以没有lib目录
# ADD target/lib ~/studio/server/eureka/lib
ADD target/eureka.jar ~/studio/server/eureka/eureka.jar