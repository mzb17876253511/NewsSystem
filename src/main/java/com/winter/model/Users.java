package com.winter.model;



import java.util.Date;

public class Users {

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

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail == null ? null : uMail.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType == null ? null : uType.trim();
    }

    public String getuImage() {
        return uImage;
    }

    public void setuImage(String uImage) {
        this.uImage = uImage == null ? null : uImage.trim();
    }

    public String getuProvince() {
        return uProvince;
    }

    public void setuProvince(String uProvince) {
        this.uProvince = uProvince == null ? null : uProvince.trim();
    }

    public String getuArea() {
        return uArea;
    }

    public void setuArea(String uArea) {
        this.uArea = uArea == null ? null : uArea.trim();
    }

    public String getuTown() {
        return uTown;
    }

    public void setuTown(String uTown) {
        this.uTown = uTown == null ? null : uTown.trim();
    }

    public String getuIntro() {
        return uIntro;
    }

    public void setuIntro(String uIntro) {
        this.uIntro = uIntro == null ? null : uIntro.trim();
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
}