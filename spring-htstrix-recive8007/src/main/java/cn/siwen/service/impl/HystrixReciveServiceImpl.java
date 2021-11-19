package cn.siwen.service.impl;

import cn.siwen.service.HystrixReciveService;
import org.springframework.stereotype.Service;

@Service
public class HystrixReciveServiceImpl implements HystrixReciveService {
    @Override
    public String ok() {
        return "404";
    }

    @Override
    public String timeOut() {
        return "404";
    }
}
