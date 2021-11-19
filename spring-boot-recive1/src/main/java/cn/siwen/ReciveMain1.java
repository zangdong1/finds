package cn.siwen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("cn.siwen.mapper")
@EnableEurekaClient
public class ReciveMain1 {
    public static void main(String[] args) {
        SpringApplication.run(ReciveMain1.class,args);
    }
}
