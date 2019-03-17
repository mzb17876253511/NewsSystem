package com.winter.model;

import java.util.Date;

public class Tinynews {
    private String tId;

    private String tUserid;

    private String tMessage;

    private String tReadnum;

    private String tLikenum;

    private String tImage;

    private Date tCreattime;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId == null ? null : tId.trim();
    }

    public String gettUserid() {
        return tUserid;
    }

    public void settUserid(String tUserid) {
        this.tUserid = tUserid == null ? null : tUserid.trim();
    }

    public String gettMessage() {
        return tMessage;
    }

    public void settMessage(String tMessage) {
        this.tMessage = tMessage == null ? null : tMessage.trim();
    }

    public String gettReadnum() {
        return tReadnum;
    }

    public void settReadnum(String tReadnum) {
        this.tReadnum = tReadnum == null ? null : tReadnum.trim();
    }

    public String gettLikenum() {
        return tLikenum;
    }

    public void settLikenum(String tLikenum) {
        this.tLikenum = tLikenum == null ? null : tLikenum.trim();
    }

    public String gettImage() {
        return tImage;
    }

    public void settImage(String tImage) {
        this.tImage = tImage == null ? null : tImage.trim();
    }

    public Date gettCreattime() {
        return tCreattime;
    }

    public void settCreattime(Date tCreattime) {
        this.tCreattime = tCreattime;
    }
}