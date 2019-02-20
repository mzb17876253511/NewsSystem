package com.winter.Controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.winter.model.Test;
import com.winter.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/14 14:30
 **/
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    // 加了ResponsBody后才能返回具体的类型，不加的话则返回界面
     @RequestMapping(value="/hi")
     @ResponseBody
     public String test(){
         return "helloworld";
     }

     @GetMapping("/templates")
     public String hello1(){
         return "/admin/hello2";
     }

    @GetMapping("/index")
    public String index(){
        return "/front/index";
    }

    @GetMapping("/technology")
    public String index1(){
        return "/front/index_technology";
    }

    @GetMapping("/test")
    public String test1(){
         return "/test";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Test> showAll(){
         List<Test> testList = testService.selectList(new EntityWrapper<Test>());

         return testList;
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest req,Test test){
         System.out.println(test.getId()+"/"+test.getTname()+"/"+test.getPhone());
         test.setId(4);
         testService.insert(test);
         return "/test";
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id")int id){
         System.out.println(id);
         testService.deleteById(id);
         return "hello";
    }
}
