package cn.siwen.service;

import cn.siwen.entity.Result;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//提供服务提供方的名称
@FeignClient(value = "CLOUD-PAYMENT-RECIVE")
public interface FeignService {
    //用restemplet请求提供者的路径
    @GetMapping("/finding/{id}")
    Result  cat(@PathVariable("id") Integer id);
}
