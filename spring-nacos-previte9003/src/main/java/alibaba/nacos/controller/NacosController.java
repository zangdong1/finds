package alibaba.nacos.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {
    @Value("${server.port}")
    String port;
    @GetMapping("pament/nacos/{id}")
    public String gets(@PathVariable Integer id){
        return  "端口号是"+port+"id是多少"+id ;
    }
}
