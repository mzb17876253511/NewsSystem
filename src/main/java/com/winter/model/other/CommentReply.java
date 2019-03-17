package com.winter.model.other;

import com.winter.model.Comment;
import com.winter.model.Users;

import java.util.List;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/3/7 11:08
 **/
public class CommentReply {
    Comment fcomment;
    List<ScommentUser> scommentUsers;
    Users user;

    public Comment getFcomment() {
        return fcomment;
    }

    public void setFcomment(Comment fcomment) {
        this.fcomment = fcomment;
    }

    public List<ScommentUser> getScommentUsers() {
        return scommentUsers;
    }

    public void setScommentUsers(List<ScommentUser> scommentUsers) {
        this.scommentUsers = scommentUsers;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
