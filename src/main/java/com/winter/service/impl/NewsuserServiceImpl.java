package com.winter.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.winter.mapper.NewsuserMapper;
import com.winter.mapper.TestMapper;
import com.winter.model.Newsuser;
import com.winter.model.Test;
import com.winter.service.NewsuserService;
import com.winter.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/16 12:47
 **/
@Service
public class NewsuserServiceImpl extends ServiceImpl<NewsuserMapper, Newsuser> implements NewsuserService {


}
