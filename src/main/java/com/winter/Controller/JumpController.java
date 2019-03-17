package com.winter.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/21 21:58
 **/
@Controller
public class JumpController {

    /* 发文系统 */
    @RequestMapping("/fawen/index1")
    public String fawenindex(){
        return "/front/fawen_index";
    }
    @RequestMapping("/fawen/textEdiot")
    public String textEdiot(){
        return "/front/fawen_textEdiot";
    }
    @RequestMapping("/fawen/textManager")
    public String textManager(){
        return "/front/fawen_textManager";
    }
    @RequestMapping("/fawen/userinfo")
    public String userInfo(){
        return "/front/fawen_userinfo";
    }
    /* 前台新闻 */
    @RequestMapping("/front/index")
    public String index(){
        return "/front/index";
    }

    @RequestMapping("/front/detail")
    public String detail(){
        return "/front/news_detail";
    }

    @RequestMapping("/front/hotpoint")
    public String detail1(){
        return "/front/index_hotpoint";
    }

    @RequestMapping("/front/person")
    public String person1(){
        return "/front/index_person";
    }

    @RequestMapping("/front/technology")
    public String detail2(){
        return "/front/index_technology";
    }
    @RequestMapping("/front/society")
    public String detail3(){
        return "/front/index_society";
    }
    @RequestMapping("/front/entertainment")
    public String detail4(){
        return "/front/index_entertainment";
    }
    @RequestMapping("/front/sports")
    public String detail5(){
        return "/front/index_sports";
    }
    @RequestMapping("/front/game")
    public String detail6(){
        return "/front/index_game";
    }

    /* 后台管理系统 */
    @RequestMapping("/admin/fawen")
    public String fw(){
        return "/admin/admin_fawen";
    }

    @RequestMapping("/admin/article")
    public String article(){
        return "/admin/admin_article";
    }

    @RequestMapping("/admin/index")
    public String adminindex(){
        return "/admin/admin_index";
    }

    @RequestMapping("/admin/login")
    public String adminlogin(){
        return "/admin/admin_login";
    }

    @RequestMapping("/admin/yulan")
    public String newsyulan(){
        return "/admin/news_yulan";
    }
}
