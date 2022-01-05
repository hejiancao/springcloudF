[TOC]

# 概述

## springcloud 与springboot版本对应关系

| Release Train       | Boot Version                     | spring cloud alibaba version |
| ------------------- | -------------------------------- | ---------------------------- |
| 2020.0.x aka Ilford | 2.4.x                            | 2021.1                       |
| Hoxton              | 2.2.x, 2.3.x (Starting with SR5) | 2.2.x                        |
| Greenwich           | 2.1.x                            | 2.1.x                        |
| Finchley            | 2.0.x                            | 2.0.x                        |
| Edgware             | 1.5.x                            | 1.5.x                        |
| Dalston             | 1.5.x                            | 1.5.x                        |


​		

# 1.注册中心

## 1.1注册中心

```
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

```
register-with-eureka: false
fetch-registry: false
```

```
开启@EnableEurekaServer
```



## 1.2高可用注册中心集群

为了让服务彼此发现需要设置

```
register-with-eureka: true
fetch-registry: true
```

# 2.服务注册与发现

```
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
```
开启@EnableDiscoveryClient
```

> @EnableEurekaClient和@EnableDiscoveryClient区别？
> EnableEurekaClient注解是基于spring-cloud-commons依赖
> EnableEurekaClient注解是基于spring-cloud-netflix依赖，只能为eureka作用。
> EnableEurekaClient只适用于Eureka作为注册中心，EnableDiscoveryClient 可以是其他注册中心。

# 3.Ribbon

使用断路器需要添加依赖

```
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

```
@LoadBalanced开启负载均衡
@EnableHystrix开启熔断器
```

```java
  @GetMapping("/hi")
  @HystrixCommand(fallbackMethod = "hiError")
  public String hello() {
    return restTemplate.getForObject("http://CLIENT/hi", String.class);
  }

  public String hiError() {
    return "Hi error!, Hystrix open!";
  }
```

# 4.Feign+Hystrix

- Feign 采用的是基于接口的注解
- Feign 整合了ribbon，具有负载均衡的能力
- 整合了Hystrix，具有熔断的能力

**为什么要使用断路器？**

在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应


**配置文件**

```
feign:
  hystrix:
    enabled: true
```

```
 1）hystrix.command.default.circuitBreaker.requestVolumeThreshold（当在配置时间窗口内达到此数量的失败后，进行短路。默认20个）
（2）hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds（短路多久以后开始尝试是否恢复，默认5s）
（3）hystrix.command.default.circuitBreaker.errorThresholdPercentage（出错百分比阈值，当达到此阈值后，开始短路。默认50%）

参考：https://github.com/Netflix/Hystrix/wiki/Configuration

```

# 5.Zuul

路由转发



# 6.zipkin服务链路追踪

在spring Cloud为F版本的时候，已经不需要自己构建Zipkin Server了，只需要下载jar即可，下载地址：

链接: https://pan.baidu.com/s/1w614Z8gJXHtqLUB6dKWOpQ 密码: 26pf

```
java -jar zipkin-server-2.10.1-exec.jar
```

访问浏览器localhost:9411

创建三个服务
zipkin-service1
zipkin-service2
zipkin-service3

每个服务配置如下：

```
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```

```
spring.zipkin.base-url=http://localhost:9411
spring.zipkin.sender.type=web
spring.sleuth.sampler.probability=1.0
```

## 6.2 D版本
D版本需要自己建立server

客户端pom
```
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```
启动类添加如下代码
```
  @Bean
  public AlwaysSampler defaultSampler(){
    return new AlwaysSampler();
  }
```
yml添加
spring.zipkin.base-url: http://localhost:9411

优秀文章：https://www.cnblogs.com/duanxz/p/7552857.html

# 7.断路器监控(Hystrix Dashboard）

Hystrix Dashboard是作为断路器状态的一个组件，提供了数据监控和友好的图形化界面

创建hystrix-dashboard服务

访问http://localhost:8767/hystrix

在界面输入：http://localhost:8762/actuator/hystrix.stream，点击确定

注意配置

```
management:
  endpoints:
    web:
      exposure:
        include: "*"
      cors:
        allowed-origins: "*"
        allowed-methods: "*"
```

# 8.断路器聚合监控(Hystrix Turbine）

略

# 9.Gateway

## 9.1服务注册与发现

### 9.1.1服务注册与发现

创建gateway服务

```
spring:
  application:
    name: gateway
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
          lower-case-service-id: true
```

spring.cloud.gateway.discovery.locator.enabled为true，表明gateway开启服务注册和发现的功能，并且spring cloud gateway自动根据服务发现为每一个服务创建了一个router，这个router将以服务名开头的请求路径转发到对应的服务。spring.cloud.gateway.discovery.locator.lowerCaseServiceId 是将请求路径上的服务名配置为小写,因为服务注册的时候，向注册中心注册时将服务名转成大写的了


### 9.1.2自定义请求路径

略
