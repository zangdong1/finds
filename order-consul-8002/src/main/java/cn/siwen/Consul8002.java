package cn.siwen;

import cn.siwen.config.MyselfRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
//设置负载均衡规则
@RibbonClient(name = "CLOUD-PAYMENT-RECIVE",configuration = MyselfRole.class)
public class Consul8002 {
    public static void main(String[] args) {
        SpringApplication.run(Consul8002.class,args);
    }
}
