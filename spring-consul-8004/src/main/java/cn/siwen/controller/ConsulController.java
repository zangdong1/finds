package cn.siwen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulController {
    @Value("${server.port}")
    private  String serverPort;
    @GetMapping("/consul")
    public String  gets(){
        return  "consul"+serverPort;
    }
}
