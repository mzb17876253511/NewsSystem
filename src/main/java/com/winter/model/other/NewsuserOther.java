package com.winter.model.other;

import com.winter.model.Newsuser;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/3/13 11:25
 **/
public class NewsuserOther {
    private Newsuser newsuser;
    private String applytime;
    private String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Newsuser getNewsuser() {
        return newsuser;
    }

    public void setNewsuser(Newsuser newsuser) {
        this.newsuser = newsuser;
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }
}
