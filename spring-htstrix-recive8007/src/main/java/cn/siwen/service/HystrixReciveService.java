package cn.siwen.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Component
@FeignClient(value = "cloud-hystrix-previte")
public interface HystrixReciveService {
    @RequestMapping("/hystrix/ok")
    public String ok();
    @RequestMapping("/hystrix/timeout")
    public String timeOut();
}
