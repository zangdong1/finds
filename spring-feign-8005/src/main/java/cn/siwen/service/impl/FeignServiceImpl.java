package cn.siwen.service.impl;

import cn.siwen.entity.Result;
import cn.siwen.service.FeignService;
import org.springframework.stereotype.Service;

@Service
public class FeignServiceImpl implements FeignService {
    @Override
    public Result cat(Integer id) {
        return new Result(405, "错误");
    }
}
