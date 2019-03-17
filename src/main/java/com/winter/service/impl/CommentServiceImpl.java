package com.winter.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.winter.mapper.CommentMapper;
import com.winter.mapper.NewsMapper;
import com.winter.model.Comment;
import com.winter.model.News;
import com.winter.service.CommentService;
import com.winter.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/16 12:47
 **/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {


}
