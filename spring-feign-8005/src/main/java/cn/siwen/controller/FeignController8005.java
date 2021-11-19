package cn.siwen.controller;

import cn.siwen.entity.Result;
import cn.siwen.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class FeignController8005 {
    @Resource
    FeignService feignService;


    @GetMapping("/get/{id}")
    public Result gets(@PathVariable("id") Integer id){
       return feignService.cat(id);
    }
}
