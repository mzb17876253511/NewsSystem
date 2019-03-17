package com.winter.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.winter.model.Test;
import org.apache.ibatis.annotations.Param;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/16 13:02
 **/
public interface TestMapper extends BaseMapper<Test> {

       int getTestListCount();
}
