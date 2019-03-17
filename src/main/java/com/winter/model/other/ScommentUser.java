package com.winter.model.other;

import com.winter.model.Comment;
import com.winter.model.Users;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/3/7 11:09
 **/
public class ScommentUser {
    Comment scomment;
    Users user;

    public Comment getScomment() {
        return scomment;
    }

    public void setScomment(Comment scomment) {
        this.scomment = scomment;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
