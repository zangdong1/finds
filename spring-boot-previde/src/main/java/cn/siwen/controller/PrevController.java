package cn.siwen.controller;

import cn.siwen.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PrevController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/gets/{id}")
    public Result gets(@PathVariable Integer id){
        //http://cloud-payment-recive/finding/
        return restTemplate.getForObject("http://CLOUD-PAYMENT-RECIVE/finding/"+id, Result.class);
    }
}
