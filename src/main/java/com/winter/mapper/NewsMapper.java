package com.winter.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.winter.model.News;
import com.winter.model.Test;

import java.util.Date;
import java.util.List;

public interface NewsMapper extends BaseMapper<News> {

    //科技
    public News getHotTechnology();
    //社会
    public News getHotSociety();
    //体育
    public News getHotSports();
    //娱乐
    public News getHotEntertainment();
    //游戏
    public News getHotGame();

    //24小时热新闻
    List<News> getHotNews(Date nowDay);

    // 获得用户 最热的 五条新闻
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