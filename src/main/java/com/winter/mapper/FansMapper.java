package com.winter.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.winter.model.Fans;

public interface FansMapper  extends BaseMapper<Fans> {
    //获得 关注数量
    int getUserCount(String userId);

    //获得 粉丝数量
    int getFansCount(String userId);
}