# zlikun-spring-cloud-03-eureka

通过profile模似集群部署

#### 启动集群节点
```
$ java -jar eureka.jar --spring.profiles.active=peer1
$ java -jar eureka.jar --spring.profiles.active=peer2
```

#### REST api
```
# 查询全部应用
$ curl -i -X GET http://localhost:8761/eureka/apps
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100  1844    0  1844    0     0  59483      0 --:--:-- --:--:-- --:--:--  120kHTTP/1.1 200
Content-Type: application/xml
Transfer-Encoding: chunked
Date: Wed, 19 Jul 2017 02:22:15 GMT

<applications>
  <versions__delta>1</versions__delta>
  <apps__hashcode>UP_1_</apps__hashcode>
  <application>
    <name>MICROSERVICE-PROVIDER-USER</name>
    <instance>
      <instanceId>zlikun:microservice-provider-user:8000</instanceId>
      <hostName>192.168.70.57</hostName>
      <app>MICROSERVICE-PROVIDER-USER</app>
      <ipAddr>192.168.70.57</ipAddr>
      <status>UP</status>
      <overriddenstatus>UNKNOWN</overriddenstatus>
      <port enabled="true">8000</port>
      <securePort enabled="false">443</securePort>
      <countryId>1</countryId>
      <dataCenterInfo class="com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo">
        <name>MyOwn</name>
      </dataCenterInfo>
      <leaseInfo>
        <renewalIntervalInSecs>30</renewalIntervalInSecs>
        <durationInSecs>90</durationInSecs>
        <registrationTimestamp>1500429766569</registrationTimestamp>
        <lastRenewalTimestamp>1500430996765</lastRenewalTimestamp>
        <evictionTimestamp>0</evictionTimestamp>
        <serviceUpTimestamp>1500429765912</serviceUpTimestamp>
      </leaseInfo>
      <metadata>
        <author>zlikun</author>
        <version>1.0.0</version>
        <email>zlikun-dev@hotmail.com</email>
      </metadata>
      <homePageUrl>http://192.168.70.57:8000/</homePageUrl>
      <statusPageUrl>http://192.168.70.57:8000/info</statusPageUrl>
      <healthCheckUrl>http://192.168.70.57:8000/health</healthCheckUrl>
      <vipAddress>microservice-provider-user</vipAddress>
      <secureVipAddress>microservice-provider-user</secureVipAddress>
      <isCoordinatingDiscoveryServer>false</isCoordinatingDiscoveryServer>
      <lastUpdatedTimestamp>1500429766569</lastUpdatedTimestamp>
      <lastDirtyTimestamp>1500429765790</lastDirtyTimestamp>
      <actionType>ADDED</actionType>
    </instance>
  </application>
</applications>
```