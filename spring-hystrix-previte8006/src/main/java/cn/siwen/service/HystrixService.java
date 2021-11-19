package cn.siwen.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.tomcat.jni.Error;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixService {
    public String ok() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取线程名称Thread.currentThread().getName()
        return "成功了"+Thread.currentThread().getName();
    }
    //fallbackMethod定义回退方法的名称, 此方法必须和hystrix的执行方法在相同类中,commandProperties配置hystrix命令的参数
    @HystrixCommand(fallbackMethod = "timeOutHandler",commandProperties ={
            //5秒内就执行正常的业务逻辑，反之就执行降级方法
            //HystrixProperty配置hystrix依赖的线程池的参数
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String timeOut()  {
        int a=3;
        //线程休眠时间
        try {
            TimeUnit.SECONDS.sleep(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "休眠了哈："+Thread.currentThread().getName()+"线程时间"+a;
    }
    //服务熔断
    public String timeOutHandler(){
        return "请等一下";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            //是否开启熔断器
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            //请求次数
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            //请求时间范围
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //失败率范围如果达到了60%。那么就直接熔断
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    //手动判断能否失败
    public String pyment(@PathVariable Integer id) {
        if(id<=0){
            //手动跑出异常
            throw new RuntimeException("异常了，开始熔断~~~");
        }
        return "欢迎"+id;
    }
//    public String  paymentCircuitBreaker_fallback(@PathVariable Integer id){
//        return "降级"+id;
//    }
    //服务熔断
//    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸，此处为60%（上面配置意思是：10秒钟内，10次请求，失败率60%就不让用了）
//            // 具体需要配置哪些参数，在 HystrixCommandProperties.java 类中
//    })
//    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
//        if (id < 0){
//            throw new RuntimeException("*****id 不能负数");
//        }
//        Integer serialNumber = ((int)Math.random())*10000;
//
//        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
//    }
//
//    //服务降级
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }





}
