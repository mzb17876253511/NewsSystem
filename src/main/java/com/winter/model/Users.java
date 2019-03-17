package com.winter.model;



import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;

public class Users {
    @TableId(value="u_id")
    private String uId;

    private String uName;

    private String uPhone;

    private String uMail;

    private String uPassword;

    private String uType;

    private String uImage;

    private String uProvince;

    private String uArea;

    private String uTown;

    private String uIntro;

    private Date uUpdatetime;

    private Date uCreattime;

    private String uUsername;

    private String uIdcard;

    private String uTelphone;

    public String getuTelphone() {
        return uTelphone;
    }

    public void setuTelphone(String uTelphone) {
        this.uTelphone = uTelphone;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public String getuImage() {
        return uImage;
    }

    public void setuImage(String uImage) {
        this.uImage = uImage;
    }

    public String getuProvince() {
        return uProvince;
    }

    public void setuProvince(String uProvince) {
        this.uProvince = uProvince;
    }

    public String getuArea() {
        return uArea;
    }

    public void setuArea(String uArea) {
        this.uArea = uArea;
    }

    public String getuTown() {
        return uTown;
    }

    public void setuTown(String uTown) {
        this.uTown = uTown;
    }

    public String getuIntro() {
        return uIntro;
    }

    public void setuIntro(String uIntro) {
        this.uIntro = uIntro;
    }

    public Date getuUpdatetime() {
        return uUpdatetime;
    }

    public void setuUpdatetime(Date uUpdatetime) {
        this.uUpdatetime = uUpdatetime;
    }

    public Date getuCreattime() {
        return uCreattime;
    }

    public void setuCreattime(Date uCreattime) {
        this.uCreattime = uCreattime;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public String getuIdcard() {
        return uIdcard;
    }

    public void setuIdcard(String uIdcard) {
        this.uIdcard = uIdcard;
    }
}