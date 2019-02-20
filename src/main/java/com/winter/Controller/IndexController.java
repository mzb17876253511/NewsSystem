package com.winter.Controller;

import com.winter.model.News;
import com.winter.service.NewsService;
import com.winter.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/17 22:35
 **/
@Controller("/index")
public class IndexController {

    @Autowired
    private NewsService newsService;

/*    @GetMapping("technology")
    @ResponseBody
    public ResponseBo tech(){
        return ResponseBo.ok();

    }*/
}
