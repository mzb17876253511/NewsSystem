package com.winter.Controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winter.model.ImgInfo;
import com.winter.model.News;

import com.winter.model.Test;
import com.winter.service.NewsService;
import com.winter.service.TestService;
import com.winter.utils.ResponseBo;
import org.jboss.logging.FormatWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/14 14:30
 **/
@Controller
public class TestController extends HttpServlet {

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

    @GetMapping("/test2")
    public String test2(){
         return "/test2";
    }

    @GetMapping("/test")
    public String test1(){
        return "/test";
    }

    @GetMapping("/wang")
    public String wang(){
        return "/wangEditor";
    }

    @GetMapping("/show")
    public String show11(){
        return "/show";
    }

    @RequestMapping("/uploadtest")
    public String show2(){
        return "/upload";
    }

    @RequestMapping("/test/href")
    @ResponseBody
    public ModelAndView href1(String count){
        System.out.println("count:"+count);
        return new ModelAndView("redirect:/front/textEdiot");
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

    @Autowired
    private NewsService newsService;

    @GetMapping("/news/show")
    @ResponseBody
    public News show(){
         int count = 4;
         News news = newsService.selectOne(new EntityWrapper<News>().eq("n_menuid",count));
         return news;
    }


    @PostMapping("/upload")
    @ResponseBody
    public ResponseBo uploadImg(@PathVariable("file") File file){
        System.out.println(file.getName());
        return ResponseBo.ok();
    }

    /* 分页测试 */
    @PostMapping("/test/page/{curPage}")
    @ResponseBody
    public ResponseBo testPage(@PathVariable("curPage") int curPage){
        PageHelper.startPage(curPage,2);
        List<Test> test = testService.selectList(new EntityWrapper<Test>());
        PageInfo<Test> testPageInfo = new PageInfo<>(test);
        return ResponseBo.ok().put("pageinfo",testPageInfo);
    }


    @RequestMapping("/test1")
    public String show3(){
        return "/test1";
    }

    @RequestMapping("/test/ceshi")
    @ResponseBody
    public ResponseBo ceshi(HttpServletRequest request, String uName,
                            @RequestParam( value="files",required=false)MultipartFile multipartFile)throws IllegalStateException, IOException {
        System.out.println(uName);

        String realpath="";
        //获取文件名
        String name="";
        if(multipartFile!=null) {
            name = multipartFile.getOriginalFilename();//直接返回文件的名字
            String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());

            String path = "E:\\NewsImg\\";
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            multipartFile.transferTo(new File(file + "\\" + "11" + "." + subffix));//保存文件


        }
        return ResponseBo.ok();
    }

    @RequestMapping("/test/ceshi1")
    @ResponseBody
    public ResponseBo ceshi1(@RequestParam(value="file1",required=false) MultipartFile multipartFile)throws ServletException,IOException{

        System.out.println("test2:成功进入");
        //获取文件名
        String name="";
        String fileName1="";

        if(multipartFile!=null) {
            name = multipartFile.getOriginalFilename();//直接返回文件的名字
            String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());
            UUID uuid = UUID.randomUUID();
            String uid = String.valueOf(uuid);
            String fileName = uid;
            fileName1 = fileName+"."+subffix;

            String path = "E:\\NewsImg\\";
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            multipartFile.transferTo(new File(file + "\\" + fileName + "." + subffix));//保存文件
        }
        return ResponseBo.ok();
    }
}
