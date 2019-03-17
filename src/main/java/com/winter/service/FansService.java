package com.winter.service;


import com.baomidou.mybatisplus.service.IService;
import com.winter.model.Fans;
import com.winter.model.Test;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/16 12:47
 **/

public interface FansService extends IService<Fans> {

    //获得 关注数量
    int getUserCount(String userId);

    //获得 粉丝数量
    int getFansCount(String userId);
}
