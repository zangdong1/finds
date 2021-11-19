package cn.siwen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//扫描了配置@Feign的接口，并创建了实例bean，默认扫描并创建所在工程下的包
@EnableFeignClients
@EnableEurekaClient
//设置负载均衡规则
//@RibbonClient(name = "CLOUD-PAYMENT-RECIVE",configuration = MyselfRole.class)
public class PrevideMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(PrevideMain8005.class,args);
    }
}
