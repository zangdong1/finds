package cn.siwen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("cn.siwen.mapper")
@EnableEurekaClient
public class ReciveMain {
    public static void main(String[] args) {
        SpringApplication.run(ReciveMain.class,args);
    }
}
