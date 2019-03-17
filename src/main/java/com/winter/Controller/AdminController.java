package com.winter.Controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.winter.model.News;
import com.winter.model.Newsuser;
import com.winter.model.Users;
import com.winter.model.other.NewsUsers;
import com.winter.model.other.NewsuserOther;
import com.winter.service.NewsService;
import com.winter.service.NewsuserService;
import com.winter.service.UsersService;
import com.winter.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/3/13 11:17
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private NewsuserService newsuserService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private NewsService newsService;

    /*
    *
    *  发文申请
    *
    * */

    //获得 发文申请列表
    @GetMapping("/getApply")
    @ResponseBody
    public ResponseBo getApply(){
        List<Newsuser> nulist = newsuserService.selectList(new EntityWrapper<Newsuser>().eq("newsuser_flag",0));
        List<NewsuserOther> nolist = new ArrayList<>();
        for(Newsuser nu:nulist){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String applytime = sdf.format(nu.getNewsuserApplytime());
            String imgPath = "/file/showImg/"+nu.getNewsuserImage();

            NewsuserOther no = new NewsuserOther();
            no.setNewsuser(nu);
            no.setApplytime(applytime);
            no.setImgPath(imgPath);
            nolist.add(no);
        }
        return ResponseBo.ok().put("nolist",nolist);
    }

    //申请通过
    @PostMapping("/applyOk/{nuId}")
    @ResponseBody
    public ResponseBo applyOk(@PathVariable("nuId") String nuId){
        try{
            Newsuser nu = newsuserService.selectById(nuId);
            String uImage = nu.getNewsuserImage();
            String uName = nu.getNewsuserName();
            String uIntro = nu.getNewsuserIntro();
            String uIdcard = nu.getNewsuserIdcard();
            String uUname = nu.getNewsuserUname();
            String uTelphone = nu.getNewsuserPhone();

            Users user = usersService.selectById(nu.getNewsuserUserid());
            user.setuImage(uImage);
            user.setuName(uName);
            user.setuIntro(uIntro);
            user.setuIdcard(uIdcard);
            user.setuName(uUname);
            user.setuTelphone(uTelphone);
            user.setuType("发文用户");
            usersService.insertOrUpdate(user);

            // flag 为 1，表示通过
            nu.setNewsuserFlag(1);
            newsuserService.insertOrUpdate(nu);

            return ResponseBo.ok();
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //取消用户通过
    @PostMapping("/applyNo/{nuId}")
    @ResponseBody
    public ResponseBo applyNo(@PathVariable("nuId") String nuId){
        try {
            Newsuser nu = newsuserService.selectById(nuId);
            //flag为2，表示已取消
            nu.setNewsuserFlag(2);
            newsuserService.insertOrUpdate(nu);
            return ResponseBo.ok();
        }catch (Exception e){
            return ResponseBo.error();
        }

    }

    /*
     *
     *  文章审核
     *
     * */

    // 文章审核列表
    @GetMapping("/getChecknews")
    @ResponseBody
    public ResponseBo getCheck(){
        try{
            List<News> newsList = newsService.selectList(new EntityWrapper<News>().eq("n_state","审核中"));
            List<NewsUsers> nuList = new ArrayList<>();
            for(News news:newsList){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String creattime = sdf.format(news.getnCreattime());

                Users user = usersService.selectById(news.getnUserid());

                NewsUsers nu = new NewsUsers();
                nu.setNews(news);
                nu.setUserName(user.getuName());
                nu.setCreattime(creattime);
                nuList.add(nu);
            }

            return ResponseBo.ok().put("nulist",nuList);
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //文章审核通过
    @PostMapping("/newsOk/{newsId}")
    @ResponseBody
    public ResponseBo newsOk(@PathVariable("newsId") String newsId){
     /*   try{*/
            News news = newsService.selectOne(new EntityWrapper<News>().eq("n_id",newsId));
            news.setnState("已发表");
            newsService.insertOrUpdate(news);
            return ResponseBo.ok();
  /*      }catch (Exception e){
            return ResponseBo.error();
        }*/
    }

    //文章审核不通过
    @PostMapping("/newsNo/{newsId}")
    @ResponseBody
    public ResponseBo newsNo(@PathVariable("newsId") String newsId){
        try{
            News news = newsService.selectOne(new EntityWrapper<News>().eq("n_id",newsId));
            news.setnState("未通过");
            newsService.insertOrUpdate(news);
            return ResponseBo.ok();
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //点击浏览，查看文章
    String nId;
    @RequestMapping("/newsView/{newsId}")
    public String jumpDetail(@PathVariable("newsId") String newsId){
        this.nId = newsId;
        return "/admin/news_yulan";
    }

    @GetMapping("/newsDetail")
    @ResponseBody
    public ResponseBo getYulan(){
        try{
            News news = newsService.selectOne(new EntityWrapper<News>().eq("n_id",nId));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creattime1 = sdf.format(news.getnCreattime());
            Users user = usersService.selectById(news.getnUserid());

            NewsUsers nu = new NewsUsers();
            nu.setNews(news);
            nu.setUserName(user.getuName());
            nu.setCreattime(creattime1);

            return ResponseBo.ok().put("newsUser",nu);
        }catch (Exception e){
            System.out.println("有错误");
            return ResponseBo.error();
        }
    }
}
