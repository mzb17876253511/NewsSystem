package com.winter.model;



import java.util.Date;

public class Comment {

    private String cId;

    private String cFid;

    private String cNewsid;

    private String cTinynewsid;

    private Date cCreattime;

    private Date cUpdatetime;

    private String cMessage;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcFid() {
        return cFid;
    }

    public void setcFid(String cFid) {
        this.cFid = cFid == null ? null : cFid.trim();
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

    public Date getcUpdatetime() {
        return cUpdatetime;
    }

    public void setcUpdatetime(Date cUpdatetime) {
        this.cUpdatetime = cUpdatetime;
    }

    public String getcMessage() {
        return cMessage;
    }

    public void setcMessage(String cMessage) {
        this.cMessage = cMessage == null ? null : cMessage.trim();
    }
}