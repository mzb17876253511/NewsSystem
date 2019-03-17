package com.winter.model;

import java.util.Date;

public class Advice {
    private String aId;

    private String aUserid;

    private String aMessage;

    private Integer aIsread;

    private Date aCreattime;

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId == null ? null : aId.trim();
    }

    public String getaUserid() {
        return aUserid;
    }

    public void setaUserid(String aUserid) {
        this.aUserid = aUserid == null ? null : aUserid.trim();
    }

    public String getaMessage() {
        return aMessage;
    }

    public void setaMessage(String aMessage) {
        this.aMessage = aMessage == null ? null : aMessage.trim();
    }

    public Integer getaIsread() {
        return aIsread;
    }

    public void setaIsread(Integer aIsread) {
        this.aIsread = aIsread;
    }

    public Date getaCreattime() {
        return aCreattime;
    }

    public void setaCreattime(Date aCreattime) {
        this.aCreattime = aCreattime;
    }
}