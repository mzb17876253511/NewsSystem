package com.winter.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.winter.mapper.NewsMapper;

import com.winter.model.News;

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
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    //科技
    public News getHotTechnology(){
        return baseMapper.getHotTechnology();
    };
    //社会
    public News getHotSociety(){
        return newsMapper.getHotSociety();
    };
    //体育
    public News getHotSports(){
        return newsMapper.getHotSports();
    };
    //娱乐
    public News getHotEntertainment(){
        return newsMapper.getHotEntertainment();
    };
    //游戏
    public News getHotGame(){
        return newsMapper.getHotGame();
    };

    public List<News> getHotNews(){
        return newsMapper.getHotNews();
    }

    public List<News> getHotFiveNews(String userId){
        return newsMapper.getHotFiveNews(userId);
    }

    //累计阅读量
    public int getBrowseSum(String userId){
        return newsMapper.getBrowseSum(userId);
    }

    //累计文章数量
    public int getNewsSum(String userId){
        return newsMapper.getNewsSum(userId);
    }

    //获得最新的三篇文章
    public List<News> getFreshNews(String userId){
        return newsMapper.getFreshNews(userId);
    }

    //获得 已发表的文章数量
    public  int getFabiaoCount(String userId){
        return newsMapper.getFabiaoCount(userId);
    }
    //获得 未通过的文章数量
    public int getNofabiaoCount(String userId){
        return newsMapper.getNofabiaoCount(userId);
    }
    //获得 草稿箱的文章数量
    public int getCaogaoCount(String userId){
        return newsMapper.getCaogaoCount(userId);
    }
    //获得 已撤回的文章数量
    public int getChehuiCount(String userId){
        return newsMapper.getChehuiCount(userId);
    }

    // 获得用户所有新闻
    public List<News> getAllnews(String userId){
        return newsMapper.getAllnews(userId);
    }
}
