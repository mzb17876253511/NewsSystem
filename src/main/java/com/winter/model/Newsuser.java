package com.winter.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

public class Newsuser {
    @TableId(value = "newsuser_id", type = IdType.UUID)
    private String newsuserId;

    private String newsuserPhone;

    private String newsuserUname;

    private String newsuserIdcard;

    private String newsuserName;

    private String newsuserIntro;

    private String newsuserImage;

    private Integer newsuserFlag;

    private String newsuserUserid;

    private Date newsuserApplytime;

    public String getNewsuserId() {
        return newsuserId;
    }

    public String getNewsuserUserid() {
        return newsuserUserid;
    }

    public void setNewsuserUserid(String newsuserUserid) {
        this.newsuserUserid = newsuserUserid;
    }

    public void setNewsuserId(String newsuserId) {
        this.newsuserId = newsuserId == null ? null : newsuserId.trim();
    }

    public String getNewsuserPhone() {
        return newsuserPhone;
    }

    public void setNewsuserPhone(String newsuserPhone) {
        this.newsuserPhone = newsuserPhone == null ? null : newsuserPhone.trim();
    }

    public String getNewsuserUname() {
        return newsuserUname;
    }

    public void setNewsuserUname(String newsuserUname) {
        this.newsuserUname = newsuserUname == null ? null : newsuserUname.trim();
    }

    public String getNewsuserIdcard() {
        return newsuserIdcard;
    }

    public void setNewsuserIdcard(String newsuserIdcard) {
        this.newsuserIdcard = newsuserIdcard == null ? null : newsuserIdcard.trim();
    }

    public String getNewsuserName() {
        return newsuserName;
    }

    public void setNewsuserName(String newsuserName) {
        this.newsuserName = newsuserName == null ? null : newsuserName.trim();
    }

    public String getNewsuserIntro() {
        return newsuserIntro;
    }

    public void setNewsuserIntro(String newsuserIntro) {
        this.newsuserIntro = newsuserIntro == null ? null : newsuserIntro.trim();
    }

    public String getNewsuserImage() {
        return newsuserImage;
    }

    public void setNewsuserImage(String newsuserImage) {
        this.newsuserImage = newsuserImage == null ? null : newsuserImage.trim();
    }

    public Integer getNewsuserFlag() {
        return newsuserFlag;
    }

    public void setNewsuserFlag(Integer newsuserFlag) {
        this.newsuserFlag = newsuserFlag;
    }

    public Date getNewsuserApplytime() {
        return newsuserApplytime;
    }

    public void setNewsuserApplytime(Date newsuserApplytime) {
        this.newsuserApplytime = newsuserApplytime;
    }
}