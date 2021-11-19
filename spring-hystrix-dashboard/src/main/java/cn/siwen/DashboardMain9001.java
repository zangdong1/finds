package cn.siwen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableEurekaClient
@EnableHystrixDashboard
@SpringBootApplication
public class DashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashboardMain9001.class,args);
    }
}
