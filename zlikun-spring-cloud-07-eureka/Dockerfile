FROM docker.io/java
MAINTAINER zlikun <zlikun-dev@hotmail.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "~/studio/server/eureka/eureka.jar"]

ADD target/lib ~/studio/server/eureka/lib
ADD target/eureka.jar ~/studio/server/eureka/eureka.jar