package cn.siwen.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyselfRole {
    @Bean
    public IRule myin(){
        //随机的规则
        return new RandomRule();
    }
}
