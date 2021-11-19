package cn.siwen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
/*eureka自动装配开关*/
@EnableEurekaServer
public class ReciveMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(ReciveMain7001.class,args);
    }
}
