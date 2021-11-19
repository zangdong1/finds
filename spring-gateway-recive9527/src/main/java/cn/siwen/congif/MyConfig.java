package cn.siwen.congif;

import com.ctc.wstx.util.StringUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyConfig implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入全局过滤"+new Date());
        //获取url路径的参数
        String username=exchange.getRequest().getQueryParams().getFirst("username");
        if (StringUtils.isEmpty(username)){
            System.out.println("您是非法用户");
            //设置http状态码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return  exchange.getResponse().setComplete();
        }
        //得到请求后放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //过滤器的优先级，越小优先级越高
        return 0;
    }
}
