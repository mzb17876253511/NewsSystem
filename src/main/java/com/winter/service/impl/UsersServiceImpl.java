package com.winter.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.winter.mapper.TestMapper;
import com.winter.mapper.UsersMapper;
import com.winter.model.Test;
import com.winter.model.Users;
import com.winter.service.TestService;
import com.winter.service.UsersService;
import org.springframework.stereotype.Service;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/16 12:47
 **/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
