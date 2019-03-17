package com.winter.model.other;

import com.winter.model.News;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/28 0:26
 **/
public class NewsUsers {
    private News news;
    private String userName;
    private String userImg;
    private String creattime;
    private String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public News getNews() {
        return news;
    }

    public String getUserName() {
        return userName;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }


}
