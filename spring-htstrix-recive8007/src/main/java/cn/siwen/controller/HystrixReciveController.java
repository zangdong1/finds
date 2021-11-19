package cn.siwen.controller;

import cn.siwen.service.HystrixReciveService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//开启服务降级,设置全局服务降级的方法名
@DefaultProperties(defaultFallback = "allOutHandler")
public class HystrixReciveController {
    @Resource
    HystrixReciveService hystrixService;
    //使用全局降级
    @HystrixCommand
    @RequestMapping("/hystrixs/ok")
    public String ok(){
        return hystrixService.ok();
    }
    @RequestMapping("/hystrixs/timeout")
    //消费降级，制定降级类型
    @HystrixCommand(fallbackMethod = "timeOutHandler",commandProperties ={
            //几秒内就执行正常的业务逻辑，反之就执行降级方法
            //系统默认是1s所以需要更改，系统默认取压马路和这边设置的最小值
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String timeout(){
        return hystrixService.timeOut();
    }
    //服务兜底方法
    public String timeOutHandler(){
        return "请消费者8007等一下";
    }
    //全局服务兜底方法
    public String allOutHandler(){
        return "全局降级";
    }
}
