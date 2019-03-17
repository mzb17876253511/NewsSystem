package com.winter.model.other;

import com.winter.model.Fans;
import com.winter.model.Users;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/3/11 21:52
 **/
public class FansUsers {
    private Fans fans;
    private Users user;

    public Fans getFans() {
        return fans;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
