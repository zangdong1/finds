package cn.siwen;

import cn.siwen.config.MyselfRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//设置负载均衡规则
@RibbonClient(name = "CLOUD-PAYMENT-RECIVE",configuration = MyselfRole.class)
public class PrevideMain000 {
    public static void main(String[] args) {
        SpringApplication.run(PrevideMain000.class,args);
    }
}
