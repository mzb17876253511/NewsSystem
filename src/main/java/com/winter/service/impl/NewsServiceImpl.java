package com.winter.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.winter.mapper.NewsMapper;

import com.winter.model.News;

import com.winter.service.NewsService;

import org.springframework.stereotype.Service;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/16 12:47
 **/
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {


}
