package com.winter.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.winter.mapper.FansMapper;
import com.winter.mapper.TestMapper;
import com.winter.model.Fans;
import com.winter.model.Test;
import com.winter.service.FansService;
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
public class FansServiceImpl extends ServiceImpl<FansMapper, Fans> implements FansService {
     @Autowired
     private FansMapper fansMapper;

    //获得 关注数量
    public int getUserCount(String userId){
        return fansMapper.getUserCount(userId);
    }

    //获得 粉丝数量
    public int getFansCount(String userId){
        return fansMapper.getFansCount(userId);
    }

}
