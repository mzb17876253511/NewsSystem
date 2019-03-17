package com.winter.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.UUID;

public class Collections {
    @TableId(value="collection_id",type = IdType.UUID)
    private String collectionId;

    private String collectionNewsid;

    private String collectionUserid;

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId == null ? null : collectionId.trim();
    }

    public String getCollectionNewsid() {
        return collectionNewsid;
    }

    public void setCollectionNewsid(String collectionNewsid) {
        this.collectionNewsid = collectionNewsid == null ? null : collectionNewsid.trim();
    }

    public String getCollectionUserid() {
        return collectionUserid;
    }

    public void setCollectionUserid(String collectionUserid) {
        this.collectionUserid = collectionUserid == null ? null : collectionUserid.trim();
    }
}