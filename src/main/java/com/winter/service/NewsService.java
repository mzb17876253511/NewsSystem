package com.winter.service;


import com.baomidou.mybatisplus.service.IService;
import com.winter.model.News;
import com.winter.model.Test;

import java.util.Date;
import java.util.List;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/16 12:47
 **/

public interface NewsService extends IService<News> {
    //科技
    News getHotTechnology();
    //社会
    News getHotSociety();
    //体育
    News getHotSports();
    //娱乐
    News getHotEntertainment();
    //游戏
    News getHotGame();

    //24小时热新闻
    List<News> getHotNews(Date nowDay);
    //用户最热的五条新闻
    List<News> getHotFiveNews(String userId);

    //累计阅读量
    int getBrowseSum(String userId);

    //累计文章数量
    int getNewsSum(String userId);

    //获得最新的三篇文章
    List<News> getFreshNews(String userId);

    //获得 已发表的文章数量
    int getFabiaoCount(String userId);
    //获得 未通过的文章数量
    int getNofabiaoCount(String userId);
    //获得 草稿箱的文章数量
    int getCaogaoCount(String userId);
    //获得 已撤回的文章数量
    int getChehuiCount(String userId);

    // 获得用户所有新闻
    List<News> getAllnews(String userId);
}
