package com.winter.Controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winter.mapper.NewsMapper;
import com.winter.model.Comment;
import com.winter.model.News;
import com.winter.model.Users;
import com.winter.model.other.CommentUser;
import com.winter.model.other.NewsUsers;
import com.winter.service.CommentService;
import com.winter.service.FansService;
import com.winter.service.NewsService;
import com.winter.service.UsersService;
import com.winter.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    private CommentService commentService;

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
                                 String uName,String uIntro,String uUsername,String uPhone,String uIdcard,
                                 @RequestParam( value="files",required=false)MultipartFile multipartFile)throws IllegalStateException, IOException{


        if(multipartFile==null) {
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
        }
            //获取文件名
            String name="";
            String fileName1="";

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

            Users user = usersService.selectById(userId);
            user.setuImage(fileName1);
            user.setuName(uName);
            user.setuIntro(uIntro);
            user.setuUsername(uUsername);
            user.setuTelphone(uPhone);
            user.setuIdcard(uIdcard);
            user.setuUpdatetime(new Date());

            System.out.println("用户信息修改成功");
            usersService.insertOrUpdate(user);

            return ResponseBo.ok();
    }

    //返回修改文章界面
    String nId;

    @RequestMapping("/update/{newsId}")
    public String updateNews(@PathVariable("newsId") String newsId){
        this.nId = newsId;
        return "/front/fawen_textUpdate";
    }

    //得到新闻信息
    @GetMapping("/getNews")
    @ResponseBody
    public ResponseBo getNews(){
        News news = newsService.selectById(nId);
        String imgPath = "/file/showImg/"+news.getnCover();
        return ResponseBo.ok().put("news",news).put("imgPath",imgPath);
    }

    //修改文章后 发表

    @RequestMapping("/fabiao/{stateId}")
    @ResponseBody
    public ModelAndView fabiao(@PathVariable("stateId") int stateId ,org.apache.catalina.servlet4preview.http.HttpServletRequest request, News news,
                               @RequestParam(value="file1",required=false) MultipartFile multipartFile)throws ServletException, IOException {

        //如果没有改变图片的话
        if(multipartFile.getOriginalFilename().isEmpty()){
            News news1 = newsService.selectById(nId);
            news1.setnTitle(request.getParameter("nTitle"));
            news1.setnMessage(request.getParameter("nMessage"));
            news1.setnMenuid(request.getParameter("nMenuid"));
            news1.setnCreattime(new Date());
            if(stateId == 1){
               news1.setnState("审核中");
            }

            newsService.insertOrUpdate(news1);
        }else{
            //获取文件名
            String name="";
            String fileName1="";

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

                News news2 = newsService.selectById(nId);

                if(stateId == 1) {
                    news2.setnState("审核中");
                }

                news2.setnTitle(request.getParameter("nTitle"));
                news2.setnMessage(request.getParameter("nMessage"));
                news2.setnCover(fileName1);
                news2.setnMenuid(request.getParameter("nMenuid"));
                news2.setnCreattime(new Date());
                newsService.insertOrUpdate(news2);
        }

        return new ModelAndView("redirect:/fawen/update/"+nId);
    }


    //获得评论管理信息
    @GetMapping("/commentData")
    @ResponseBody
    public ResponseBo commentData(HttpServletRequest request){
        HttpSession session = request.getSession();
        String userId1 = (String)session.getAttribute("userId");

        //新闻题目列表
        List<News> newsList = newsService.selectList(new EntityWrapper<News>().
                eq("n_userid",userId1).eq("n_state","已发表").orderBy("n_creattime",false));
        News news = newsList.get(0);
        String newsId = news.getNId();
        //评论列表
        List<Comment> commentList = commentService.selectList(new EntityWrapper<Comment>().eq("c_newsid",newsId));
        List<CommentUser> cuList = new ArrayList<>();
        for(Comment comment:commentList){
            String userId = comment.getcUserid();
            Users user = usersService.selectById(userId);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creattime = sdf.format(comment.getcCreattime());

            String imgPath = "/file/showImg/"+user.getuImage();

            CommentUser cu = new CommentUser();
            cu.setComment(comment);
            cu.setUsers(user);
            cu.setImgPath(imgPath);
            cu.setCreattime(creattime);
            cuList.add(cu);
        }
        return ResponseBo.ok().put("cuList",cuList).put("newsList",newsList);
    }

    @PostMapping("/getComment/{newsId}")
    @ResponseBody
    public ResponseBo getComment(@PathVariable("newsId") String newsId){
        //评论列表
        List<Comment> commentList = commentService.selectList(new EntityWrapper<Comment>().eq("c_newsid",newsId));
        List<CommentUser> cuList = new ArrayList<>();
        for(Comment comment:commentList){
            String userId = comment.getcUserid();
            Users user = usersService.selectById(userId);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creattime = sdf.format(comment.getcCreattime());

            String imgPath = "/file/showImg/"+user.getuImage();

            CommentUser cu = new CommentUser();
            cu.setComment(comment);
            cu.setUsers(user);
            cu.setImgPath(imgPath);
            cu.setCreattime(creattime);
            cuList.add(cu);
        }
        return ResponseBo.ok().put("cuList",cuList);
    }

    //删除评论
    @PostMapping("/deleteComment/{cId}/{newsId}")
    @ResponseBody
    public ResponseBo deleteComment(@PathVariable("cId") String cId,@PathVariable("newsId") String newsId){
        commentService.deleteById(cId);
        //评论列表
        List<Comment> commentList = commentService.selectList(new EntityWrapper<Comment>().eq("c_newsid",newsId));
        List<CommentUser> cuList = new ArrayList<>();
        for(Comment comment:commentList){
            String userId = comment.getcUserid();
            Users user = usersService.selectById(userId);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creattime = sdf.format(comment.getcCreattime());

            String imgPath = "/file/showImg/"+user.getuImage();

            CommentUser cu = new CommentUser();
            cu.setComment(comment);
            cu.setUsers(user);
            cu.setImgPath(imgPath);
            cu.setCreattime(creattime);
            cuList.add(cu);
        }
        return ResponseBo.ok().put("cuList",cuList);

    }
}
