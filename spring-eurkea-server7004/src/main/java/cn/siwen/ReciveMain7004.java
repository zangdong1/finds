package cn.siwen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ReciveMain7004 {
    public static void main(String[] args) {
        SpringApplication.run(ReciveMain7004.class,args);
    }
}
