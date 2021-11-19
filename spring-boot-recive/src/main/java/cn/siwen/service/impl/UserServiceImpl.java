package cn.siwen.service.impl;

import cn.siwen.entity.User;
import cn.siwen.mapper.UserMapper;
import cn.siwen.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
