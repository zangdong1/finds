package cn.siwen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableDiscoveryClient可以是其他注册中心。
@EnableDiscoveryClient
//扫描了配置@Feign的接口，并创建了实例bean，默认扫描并创建所在工程下的包
@EnableFeignClients
@EnableEurekaClient
//消费端开启hystrix注解
@EnableHystrix
public class  HystrixRecive {
    public static void main(String[] args) {
        SpringApplication.run(HystrixRecive.class,args);
    }
}
