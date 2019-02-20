package com.winter.model;



import java.util.Date;

public class Menu {

    private String mId;

    private String mUserid;

    private String mFid;

    private String mName;

    private Date mCreattime;

    private Date mUpdatetime;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId == null ? null : mId.trim();
    }

    public String getmUserid() {
        return mUserid;
    }

    public void setmUserid(String mUserid) {
        this.mUserid = mUserid == null ? null : mUserid.trim();
    }

    public String getmFid() {
        return mFid;
    }

    public void setmFid(String mFid) {
        this.mFid = mFid == null ? null : mFid.trim();
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public Date getmCreattime() {
        return mCreattime;
    }

    public void setmCreattime(Date mCreattime) {
        this.mCreattime = mCreattime;
    }

    public Date getmUpdatetime() {
        return mUpdatetime;
    }

    public void setmUpdatetime(Date mUpdatetime) {
        this.mUpdatetime = mUpdatetime;
    }
}