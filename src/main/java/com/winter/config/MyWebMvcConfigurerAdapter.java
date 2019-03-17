package com.winter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/25 21:56
 **/
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //指向外部目录
        registry.addResourceHandler("NewsImg/**").addResourceLocations("file:E:/NewsImg/");
        super.addResourceHandlers(registry);
    }
}

