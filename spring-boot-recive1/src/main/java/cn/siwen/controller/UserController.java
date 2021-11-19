package cn.siwen.controller;


import cn.siwen.entity.Result;
import cn.siwen.entity.User;
import cn.siwen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${server.port}")
    String port;
    @GetMapping("/finding/{id}")
    public Result finding(@PathVariable Integer id){
        User user=userService.getById(id);
        Result results=new Result();
        if (user!=null){
            results.setCode(200);
            results.setData(user.toString()+port);
        }else{
            results.setCode(400);
            results.setData(null);
        }
        return results;
    }
}
