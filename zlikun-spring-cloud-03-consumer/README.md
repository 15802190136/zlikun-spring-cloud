#### <http://localhost:8010/user/1>
```
{
    "id": 1,
    "username": "account1",
    "name": "张三",
    "age": 20,
    "balance": 100
}
```

#### <http://localhost:8010/user-instance>
```
[
    {
        "host": "192.168.70.57",
        "port": 8000,
        "metadata": {
            "author": "zlikun",
            "version": "1.0.0",
            "email": "zlikun-dev@hotmail.com"
        },
        "uri": "http://192.168.70.57:8000",
        "serviceId": "MICROSERVICE-PROVIDER-USER",
        "secure": false,
        "instanceInfo": {
            "instanceId": "zlikun:microservice-provider-user:8000",
            "app": "MICROSERVICE-PROVIDER-USER",
            "appGroupName": null,
            "ipAddr": "192.168.70.57",
            "sid": "na",
            "homePageUrl": "http://192.168.70.57:8000/",
            "statusPageUrl": "http://192.168.70.57:8000/info",
            "healthCheckUrl": "http://192.168.70.57:8000/health",
            "secureHealthCheckUrl": null,
            "vipAddress": "microservice-provider-user",
            "secureVipAddress": "microservice-provider-user",
            "countryId": 1,
            "dataCenterInfo": {
                "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
                "name": "MyOwn"
            },
            "hostName": "192.168.70.57",
            "status": "UP",
            "leaseInfo": {
                "renewalIntervalInSecs": 30,
                "durationInSecs": 90,
                "registrationTimestamp": 1500352873495,
                "lastRenewalTimestamp": 1500353173308,
                "evictionTimestamp": 0,
                "serviceUpTimestamp": 1500352872832
            },
            "isCoordinatingDiscoveryServer": false,
            "metadata": {
                "author": "zlikun",
                "version": "1.0.0",
                "email": "zlikun-dev@hotmail.com"
            },
            "lastUpdatedTimestamp": 1500352873495,
            "lastDirtyTimestamp": 1500352872723,
            "actionType": "ADDED",
            "asgName": null,
            "overriddenStatus": "UNKNOWN"
        }
    }
]
```