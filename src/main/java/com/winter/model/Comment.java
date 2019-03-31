package com.winter.model;

import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;

public class Comment {
    @TableId(value = "c_id")
    private String cId;

    private String cNewsid;

    private String cUserid;

    private String cTinynewsid;

    private Date cCreattime;

    private String cMessage;

    private int cLikenum;

    public int getcLikenum() {
        return cLikenum;
    }

    public void setcLikenum(int cLikenum) {
        this.cLikenum = cLikenum;
    }

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcNewsid() {
        return cNewsid;
    }

    public void setcNewsid(String cNewsid) {
        this.cNewsid = cNewsid == null ? null : cNewsid.trim();
    }

    public String getcTinynewsid() {
        return cTinynewsid;
    }

    public void setcTinynewsid(String cTinynewsid) {
        this.cTinynewsid = cTinynewsid == null ? null : cTinynewsid.trim();
    }

    public Date getcCreattime() {
        return cCreattime;
    }

    public void setcCreattime(Date cCreattime) {
        this.cCreattime = cCreattime;
    }

    public String getcMessage() {
        return cMessage;
    }

    public void setcUserid(String cUserid) {
        this.cUserid = cUserid == null ? null : cUserid.trim();
    }

    public String getcUserid() {
        return cUserid;
    }

    public void setcMessage(String cMessage) {
        this.cMessage = cMessage == null ? null : cMessage.trim();
    }
}