package com.winter.model;

import java.util.Arrays;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/24 22:59
 **/
public class ImgInfo {

    private Integer error;
    private String[] url;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String[] getUrl() {
        return url;
    }

    public void setUrl(String[] url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImgInfo [error=" + error + ", url=" + Arrays.toString(url) + "]";
    }

}
