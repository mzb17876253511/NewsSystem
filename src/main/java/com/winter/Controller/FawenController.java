package com.winter.Controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winter.mapper.NewsMapper;
import com.winter.model.News;
import com.winter.model.Users;
import com.winter.model.other.NewsUsers;
import com.winter.service.FansService;
import com.winter.service.NewsService;
import com.winter.service.UsersService;
import com.winter.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/3/8 15:05
 **/
@Controller
@RequestMapping("/fawen")
public class FawenController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private FansService fansService;
    @Autowired
    private UsersService usersService;

    //发文系统首页
    @GetMapping("/index")
    @ResponseBody
    public ResponseBo fawenindex(HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            String id = (String) session.getAttribute("userId");
            int fansCount = fansService.getFansCount(id);
            int browseCount = newsService.getBrowseSum(id);
            int newsCount = newsService.getNewsSum(id);

            //最新文章 - 3篇
            List<News> newsList = newsService.getFreshNews(id);
            List<NewsUsers> newsTime = new ArrayList<>();
            for(News news:newsList){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String creattime = sdf.format(news.getnCreattime());

                NewsUsers newstime = new NewsUsers();
                newstime.setNews(news);
                newstime.setCreattime(creattime);
                newsTime.add(newstime);
            }

            return ResponseBo.ok().put("fansCount",fansCount).put("browseCount",browseCount)
                    .put("newsCount",newsCount).put("newsList",newsTime);
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //全部文章列表
    @PostMapping("/textManager/all/{curPage}")
    @ResponseBody
    public ResponseBo textManager(@PathVariable("curPage") int curPage, HttpServletRequest request){
        try {
            //通过session获得用户id
            HttpSession session = request.getSession();
            String id = (String) session.getAttribute("userId");

            PageHelper.startPage(curPage,3);
            List<News> NewsList = newsService.getAllnews(id);
            List<NewsUsers> newsUsersList = new ArrayList<>();
            for(News news:NewsList){
                NewsUsers nu = new NewsUsers();
                nu.setNews(news);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(news.getnCreattime());
                nu.setCreattime(time);
                newsUsersList.add(nu);
            }
            PageInfo<NewsUsers> newsUsersPageInfo = new PageInfo<>(newsUsersList);

            //获得文章数量
            int newsCount = newsService.getNewsSum(id);
            int pageCount = newsCount/3;
            if(newsCount % 3 !=0){
                pageCount = pageCount + 1;
            }
            return ResponseBo.ok().put("pageinfo",newsUsersPageInfo).put("newsCount",newsCount).put("pageCount",pageCount);
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //已发表文章列表
    @PostMapping("/textManager/fabiao/{curPage}")
    @ResponseBody
    public ResponseBo textfabiao(@PathVariable("curPage") int curPage, HttpServletRequest request){
        try {
            //通过session获得用户id
            HttpSession session = request.getSession();
            String id = (String) session.getAttribute("userId");

            PageHelper.startPage(curPage,3);
            List<News> NewsList1 = newsService.selectList(new EntityWrapper<News>().eq("n_userid",id ).eq("n_state","已发表").orderBy("n_creattime",false));
            List<NewsUsers> newsUsersList = new ArrayList<>();
            for(News news:NewsList1){
                NewsUsers nu2 = new NewsUsers();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(news.getnCreattime());
                nu2.setNews(news);
                nu2.setCreattime(time);
                newsUsersList.add(nu2);
            }
            PageInfo<NewsUsers> newsUsersPageInfo = new PageInfo<>(newsUsersList);

            //获得文章数量
            int newsCount = newsService.getFabiaoCount(id);
            System.out.println("newsCount:"+newsCount);
            int pageCount = newsCount/3;
            if(newsCount % 3 !=0){
                pageCount = pageCount + 1;
            }
            return ResponseBo.ok().put("pageinfo",newsUsersPageInfo).put("newsCount",newsCount).put("pageCount",pageCount);
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //未通过文章列表
    @PostMapping("/textManager/nofabiao/{curPage}")
    @ResponseBody
    public ResponseBo textnofabiao(@PathVariable("curPage") int curPage, HttpServletRequest request){
        try {
            //通过session获得用户id
            HttpSession session = request.getSession();
            String id = (String) session.getAttribute("userId");

            PageHelper.startPage(curPage,3);
            List<News> NewsList2 = newsService.selectList(new EntityWrapper<News>().eq("n_userid",id ).eq("n_state","未通过").orderBy("n_creattime",false));
            List<NewsUsers> newsUsersList = new ArrayList<>();
            for(News news:NewsList2){
                NewsUsers nu3 = new NewsUsers();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(news.getnCreattime());
                nu3.setNews(news);
                nu3.setCreattime(time);
                newsUsersList.add(nu3);
            }
            PageInfo<NewsUsers> newsUsersPageInfo = new PageInfo<>(newsUsersList);

            //获得文章数量
            int newsCount = newsService.getNofabiaoCount(id);
            System.out.println("newsCount:"+newsCount);
            int pageCount = newsCount/3;
            if(newsCount % 3 !=0){
                pageCount = pageCount + 1;
            }
            return ResponseBo.ok().put("pageinfo",newsUsersPageInfo).put("newsCount",newsCount).put("pageCount",pageCount);
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //草稿文章列表
    @PostMapping("/textManager/caogao/{curPage}")
    @ResponseBody
    public ResponseBo textcaogao(@PathVariable("curPage") int curPage, HttpServletRequest request){
        try {
            //通过session获得用户id
            HttpSession session = request.getSession();
            String id = (String) session.getAttribute("userId");

            PageHelper.startPage(curPage,3);
            List<News> NewsList3 = newsService.selectList(new EntityWrapper<News>().eq("n_userid",id ).eq("n_state","草稿").orderBy("n_creattime",false));
            List<NewsUsers> newsUsersList = new ArrayList<>();
            for(News news:NewsList3){
                NewsUsers nu3 = new NewsUsers();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(news.getnCreattime());
                nu3.setNews(news);
                nu3.setCreattime(time);
                newsUsersList.add(nu3);
            }
            PageInfo<NewsUsers> newsUsersPageInfo = new PageInfo<>(newsUsersList);

            //获得文章数量
            int newsCount = newsService.getCaogaoCount(id);
            System.out.println("newsCount:"+newsCount);
            int pageCount = newsCount/3;
            if(newsCount % 3 !=0){
                pageCount = pageCount + 1;
            }
            return ResponseBo.ok().put("pageinfo",newsUsersPageInfo).put("newsCount",newsCount).put("pageCount",pageCount);
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //已撤回文章列表
    @PostMapping("/textManager/chehui/{curPage}")
    @ResponseBody
    public ResponseBo textchehui(@PathVariable("curPage") int curPage, HttpServletRequest request){
        try {
            //通过session获得用户id
            HttpSession session = request.getSession();
            String id = (String) session.getAttribute("userId");

            PageHelper.startPage(curPage,3);
            List<News> NewsList2 = newsService.selectList(new EntityWrapper<News>().eq("n_userid",id ).eq("n_state","已撤回").orderBy("n_creattime",false));
            List<NewsUsers> newsUsersList = new ArrayList<>();
            for(News news:NewsList2){
                NewsUsers nu3 = new NewsUsers();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(news.getnCreattime());
                nu3.setNews(news);
                nu3.setCreattime(time);
                newsUsersList.add(nu3);
            }
            PageInfo<NewsUsers> newsUsersPageInfo = new PageInfo<>(newsUsersList);

            //获得文章数量
            int newsCount = newsService.getChehuiCount(id);
            System.out.println("newsCount:"+newsCount);
            int pageCount = newsCount/3;
            if(newsCount % 3 !=0){
                pageCount = pageCount + 1;
            }
            return ResponseBo.ok().put("pageinfo",newsUsersPageInfo).put("newsCount",newsCount).put("pageCount",pageCount);
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //删除文章
    @PostMapping("/delete/{newsId}")
    @ResponseBody
    public ResponseBo deleteNews(@PathVariable("newsId") String newsId){
        try {
            newsService.deleteById(newsId);
            System.out.println("删除文章成功");
            return ResponseBo.ok();
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //撤回文章
    @PostMapping("/chehui/{newsId}")
    @ResponseBody
    public ResponseBo chehuiNews(@PathVariable("newsId") String newsId){
        try {
            News news = newsService.selectById(newsId);
            news.setnState("已撤回");
            newsService.insertOrUpdate(news);
            System.out.println("撤回文章成功");
            return ResponseBo.ok();
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //帐号设置得到用户信息
    @GetMapping("/getUserinfo")
    @ResponseBody
    public ResponseBo userInfo(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            String id = (String)session.getAttribute("userId");
            //String id = "3";
            Users user = usersService.selectById(id);
            return ResponseBo.ok().put("user",user);

        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //帐号设置修改用户信息
    @PostMapping("/updateUser/{userId}")
    @ResponseBody
    public ResponseBo updateUser(@PathVariable("userId") String userId,HttpServletRequest request,
                                 String uName,String uIntro,String uUsername,String uPhone,String uIdcard){

        try{
            Users user = usersService.selectById(userId);
            user.setuName(uName);
            user.setuIntro(uIntro);
            user.setuUsername(uUsername);
            user.setuTelphone(uPhone);
            user.setuIdcard(uIdcard);
            user.setuUpdatetime(new Date());

            System.out.println("用户信息修改成功");
            usersService.insertOrUpdate(user);
            return ResponseBo.ok();
        }catch (Exception e){
            System.out.println("用户信息修改异常");
            return ResponseBo.error();
        }
    }
}
