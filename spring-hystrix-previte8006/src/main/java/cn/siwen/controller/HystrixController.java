package cn.siwen.controller;

import cn.siwen.service.HystrixService;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {
    @Autowired
    HystrixService hystrixServic;
    @RequestMapping("/hystrix/ok")
    public String ok(){
        return hystrixServic.ok();
    }
    @RequestMapping("/hystrix/timeout")
    public String timeout()  {
        return hystrixServic.timeOut();
    }


    @RequestMapping("/hystrix/pyment/{id}")
    public String pyment(@PathVariable Integer id){
        return hystrixServic.pyment(id);
    }
}
