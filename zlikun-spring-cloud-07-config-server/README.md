# zlikun-spring-cloud-07-config-server

#### 依赖
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

#### 配置
```
# 配置远程仓库
spring:
  cloud:
    config:
      server:
        git:
          uri: https://gitee.com/zlikun/zlikun-spring-cloud-config
          search-paths: example/user
          username: zlikun
          password: ******
          
# 本地调试可以使用本地目录
spring:
  cloud:
    config:
      server:
        git:
          uri: file:///C:/Users/zlikun/AppData/Local/Temp/config-repo-1714554460586737619
```

#### 访问
```
# 访问主分支(master)
# http://localhost:7001/user/dev
{
    "name": "user",
    "profiles": [
        "dev"
    ],
    "label": null,
    "version": null,
    "state": null,
    "propertySources": [
        {
            "name": "https://gitee.com/zlikun/zlikun-spring-cloud-config/example/user/user-dev.properties",
            "source": {
                "from": "git-dev-1.0"
            }
        },
        {
            "name": "https://gitee.com/zlikun/zlikun-spring-cloud-config/example/user/user.properties",
            "source": {
                "from": "git-default-1.0"
            }
        }
    ]
}

# 访问指定分支
# http://localhost:7001/user/prod/$branch
# http://localhost:7001/user/prod/v2.0
{
    "name": "user",
    "profiles": [
        "prod"
    ],
    "label": "v2.0",
    "version": null,
    "state": null,
    "propertySources": [
        {
            "name": "https://gitee.com/zlikun/zlikun-spring-cloud-config/example/user/user-prod.properties",
            "source": {
                "from": "git-prod-2.0"
            }
        },
        {
            "name": "https://gitee.com/zlikun/zlikun-spring-cloud-config/example/user/user.properties",
            "source": {
                "from": "git-default-2.0"
            }
        }
    ]
}
```
