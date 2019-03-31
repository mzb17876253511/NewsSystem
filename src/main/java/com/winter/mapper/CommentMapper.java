package com.winter.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.winter.model.Advice;
import com.winter.model.Comment;

public interface CommentMapper extends BaseMapper<Comment> {
    //获得新闻总的评论数
    int getCommentsum(String newsId);
}