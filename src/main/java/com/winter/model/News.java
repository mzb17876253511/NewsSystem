package com.winter.model;



import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;

public class News {
    @TableId(value="n_id")
    private String nId;

    private String nMenuid;

    private String nUserid;

    private String nState;

    private String nTitle;

    private String nCover;

    private String nMessage;

    private Date nCreattime;

    private Date nUpdatetime;

    private Integer nCommentnum;

    private Integer nBrowsenum;

    private Integer nLikenum;

    public String getNId() {
        return nId;
    }

    public void setNId(String nId) {
        this.nId = nId;
    }

    public String getnState() {
        return nState;
    }

    public void setnState(String nState) {
        this.nState = nState;
    }

    public Integer getnLikenum() {
        return nLikenum;
    }

    public void setnLikenum(Integer nLikenum) {
        this.nLikenum = nLikenum;
    }

    public String getnMenuid() {
        return nMenuid;
    }

    public void setnMenuid(String nMenuid) {
        this.nMenuid = nMenuid == null ? null : nMenuid.trim();
    }

    public String getnUserid() {
        return nUserid;
    }

    public void setnUserid(String nUserid) {
        this.nUserid = nUserid == null ? null : nUserid.trim();
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle == null ? null : nTitle.trim();
    }

    public String getnCover() {
        return nCover;
    }

    public void setnCover(String nCover) {
        this.nCover = nCover == null ? null : nCover.trim();
    }

    public String getnMessage() {
        return nMessage;
    }

    public void setnMessage(String nMessage) {
        this.nMessage = nMessage == null ? null : nMessage.trim();
    }

    public Date getnCreattime() {
        return nCreattime;
    }

    public void setnCreattime(Date nCreattime) {
        this.nCreattime = nCreattime;
    }

    public Date getnUpdatetime() {
        return nUpdatetime;
    }

    public void setnUpdatetime(Date nUpdatetime) {
        this.nUpdatetime = nUpdatetime;
    }

    public Integer getnCommentnum() {
        return nCommentnum;
    }

    public void setnCommentnum(Integer nCommentnum) {
        this.nCommentnum = nCommentnum;
    }

    public Integer getnBrowsenum() {
        return nBrowsenum;
    }

    public void setnBrowsenum(Integer nBrowsenum) {
        this.nBrowsenum = nBrowsenum;
    }
}