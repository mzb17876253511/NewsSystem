package com.winter.Controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.winter.model.Collections;
import com.winter.model.Comment;
import com.winter.model.News;
import com.winter.model.Users;
import com.winter.model.other.CommentReply;
import com.winter.model.other.CommentUser;
import com.winter.model.other.NewsUsers;
import com.winter.model.other.ScommentUser;
import com.winter.service.CollectionsService;
import com.winter.service.CommentService;
import com.winter.service.NewsService;
import com.winter.service.UsersService;
import com.winter.utils.ResponseBo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/23 15:11
 **/
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CollectionsService collectionsService;

    /* 轮播新闻和热点新闻列表 */
    @GetMapping("/lunbo")
    @ResponseBody
    public ResponseBo hotneww(){
        News technology = newsService.getHotTechnology();
        String imgPath1 = "/file/showImg/"+technology.getnCover();
        NewsUsers nu1 = new NewsUsers();
        nu1.setImgPath(imgPath1);
        nu1.setNews(technology);

        News sports = newsService.getHotSports();
        String imgPath2 = "/file/showImg/"+sports.getnCover();
        NewsUsers nu2 = new NewsUsers();
        nu2.setImgPath(imgPath2);
        nu2.setNews(sports);

        News society = newsService.getHotSociety();
        String imgPath3 = "/file/showImg/"+society.getnCover();
        NewsUsers nu3 = new NewsUsers();
        nu3.setImgPath(imgPath3);
        nu3.setNews(society);

        News entertainment = newsService.getHotEntertainment();
        String imgPath4 = "/file/showImg/"+entertainment.getnCover();
        NewsUsers nu4 = new NewsUsers();
        nu4.setImgPath(imgPath4);
        nu4.setNews(entertainment);

        News game = newsService.getHotGame();
        String imgPath5 = "/file/showImg/"+game.getnCover();
        NewsUsers nu5 = new NewsUsers();
        nu5.setImgPath(imgPath5);
        nu5.setNews(game);

        return ResponseBo.ok().put("technology",nu1).put("sports",nu2)
                .put("society",nu3).put("entertainment",nu4).put("game",nu5);
    }


    /* 热点新闻列表 */
    @PostMapping("/hotNews/{count}")
    @ResponseBody
    public ResponseBo hotnews(@PathVariable("count") int count){
        PageHelper.startPage(1,count);
        List<News> hotNews = newsService.selectList(new EntityWrapper<News>().eq("n_state","已发表").orderBy("n_creattime",false));
        List<NewsUsers> nuList = new ArrayList<NewsUsers>();
        for(News news:hotNews){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creattime = sdf.format(news.getnCreattime());

            String imgPath = "/file/showImg/"+news.getnCover();

            String userId = news.getnUserid();
            Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",userId));
            String userImgpath = "/file/showImg/"+user.getuImage();

            NewsUsers nu = new NewsUsers();
            nu.setNews(news);
            nu.setImgPath(imgPath);
            nu.setUserName(user.getuName());
            nu.setUserImg(userImgpath);
            nu.setCreattime(creattime);
            nuList.add(nu);
        }
        PageInfo<NewsUsers> newsUsersPageInfo = new PageInfo<>(nuList);

        return ResponseBo.ok().put("pageinfo",newsUsersPageInfo);
    }

    @PostMapping("/techNews/{count}")
    @ResponseBody
    public ResponseBo technews(@PathVariable("count") int count){
        PageHelper.startPage(1,count);
        List<News> techNews = newsService.selectList(new EntityWrapper<News>().eq("n_menuid","科技").eq("n_state","已发表").orderBy("n_creattime",false));
        List<NewsUsers> nuList = new ArrayList<NewsUsers>();
        for(News news:techNews){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creattime = sdf.format(news.getnCreattime());

            String imgPath = "/file/showImg/"+news.getnCover();

            String userId = news.getnUserid();
            Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",userId));
            String userImgpath = "/file/showImg/"+user.getuImage();

            NewsUsers nu = new NewsUsers();
            nu.setNews(news);
            nu.setImgPath(imgPath);
            nu.setUserName(user.getuName());
            nu.setUserImg(userImgpath);
            nu.setCreattime(creattime);
            nuList.add(nu);
        }
        PageInfo<NewsUsers> newsUsersPageInfo = new PageInfo<>(nuList);

        return ResponseBo.ok().put("pageinfo",newsUsersPageInfo);
    }


    @PostMapping("/societyNews/{count}")
    @ResponseBody
    public ResponseBo societynews(@PathVariable("count") int count){
        PageHelper.startPage(1,count);
        List<News> societyNews = newsService.selectList(new EntityWrapper<News>().eq("n_menuid","社会").eq("n_state","已发表").orderBy("n_creattime",false));
        List<NewsUsers> nuList = new ArrayList<NewsUsers>();
        for(News news:societyNews){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creattime = sdf.format(news.getnCreattime());

            String imgPath = "/file/showImg/"+news.getnCover();

            String userId = news.getnUserid();
            Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",userId));
            String userImgpath = "/file/showImg/"+user.getuImage();

            NewsUsers nu = new NewsUsers();
            nu.setNews(news);
            nu.setImgPath(imgPath);
            nu.setUserName(user.getuName());
            nu.setUserImg(userImgpath);
            nu.setCreattime(creattime);
            nuList.add(nu);
        }
        PageInfo<NewsUsers> newsUsersPageInfo = new PageInfo<>(nuList);

        return ResponseBo.ok().put("pageinfo",newsUsersPageInfo);
    }

    @PostMapping("/enterNews/{count}")
    @ResponseBody
    public ResponseBo enternews(@PathVariable("count") int count){
        PageHelper.startPage(1,count);
        List<News> enterNews = newsService.selectList(new EntityWrapper<News>().eq("n_menuid","娱乐").eq("n_state","已发表").orderBy("n_creattime",false));
        List<NewsUsers> nuList = new ArrayList<NewsUsers>();
        for(News news:enterNews){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creattime = sdf.format(news.getnCreattime());

            String imgPath = "/file/showImg/"+news.getnCover();

            String userId = news.getnUserid();
            Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",userId));
            String userImgpath = "/file/showImg/"+user.getuImage();

            NewsUsers nu = new NewsUsers();
            nu.setNews(news);
            nu.setImgPath(imgPath);
            nu.setUserName(user.getuName());
            nu.setUserImg(userImgpath);
            nu.setCreattime(creattime);
            nuList.add(nu);
        }
        PageInfo<NewsUsers> newsUsersPageInfo = new PageInfo<>(nuList);

        return ResponseBo.ok().put("pageinfo",newsUsersPageInfo);
    }

    @PostMapping("/sportsNews/{count}")
    @ResponseBody
    public ResponseBo sprotsnews(@PathVariable("count") int count){
        PageHelper.startPage(1,count);
        List<News> sportsNews = newsService.selectList(new EntityWrapper<News>().eq("n_menuid","体育").eq("n_state","已发表").orderBy("n_creattime",false));
        List<NewsUsers> nuList = new ArrayList<NewsUsers>();
        for(News news:sportsNews){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creattime = sdf.format(news.getnCreattime());

            String imgPath = "/file/showImg/"+news.getnCover();

            String userId = news.getnUserid();
            Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",userId));
            String userImgpath = "/file/showImg/"+user.getuImage();

            NewsUsers nu = new NewsUsers();
            nu.setNews(news);
            nu.setImgPath(imgPath);
            nu.setUserName(user.getuName());
            nu.setUserImg(userImgpath);
            nu.setCreattime(creattime);
            nuList.add(nu);
        }
        PageInfo<NewsUsers> newsUsersPageInfo = new PageInfo<>(nuList);

        return ResponseBo.ok().put("pageinfo",newsUsersPageInfo);
    }

    @PostMapping("/gameNews/{count}")
    @ResponseBody
    public ResponseBo gamenews(@PathVariable("count") int count){
        PageHelper.startPage(1,count);
        List<News> gameNews = newsService.selectList(new EntityWrapper<News>().eq("n_menuid","游戏").eq("n_state","已发表").orderBy("n_creattime",false));
        List<NewsUsers> nuList = new ArrayList<NewsUsers>();
        for(News news:gameNews){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creattime = sdf.format(news.getnCreattime());

            String imgPath = "/file/showImg/"+news.getnCover();

            String userId = news.getnUserid();
            Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",userId));
            String userImgpath = "/file/showImg/"+user.getuImage();

            NewsUsers nu = new NewsUsers();
            nu.setNews(news);
            nu.setImgPath(imgPath);
            nu.setUserName(user.getuName());
            nu.setUserImg(userImgpath);
            nu.setCreattime(creattime);
            nuList.add(nu);
        }
        PageInfo<NewsUsers> newsUsersPageInfo = new PageInfo<>(nuList);

        return ResponseBo.ok().put("pageinfo",newsUsersPageInfo);
    }

    /* 24小时热闻 */
    @GetMapping("/hotNew")
    @ResponseBody
    public List<NewsUsers> hotnews1(){
        List<News> newsList = newsService.getHotNews(new Date());
        List<NewsUsers> nuList = new ArrayList<>();
        for(News news:newsList){
            String imgPath = "/file/showImg/"+news.getnCover();
            NewsUsers nu = new NewsUsers();
            nu.setImgPath(imgPath);
            nu.setNews(news);
            nuList.add(nu);
        }
        return nuList;
    }

    @RequestMapping("/fabiao")
    @ResponseBody
    public ModelAndView fabiao(HttpServletRequest request, News news,
              @RequestParam(value="file1",required=false) MultipartFile multipartFile)throws ServletException, IOException {
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

        System.out.println("fileName1:--------"+fileName1);

        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");

        UUID uuid= UUID.randomUUID();
        String nid =  String.valueOf(uuid);
        news.setnUserid(userId);
        news.setnState("审核中");
        news.setNId(nid);
        news.setnTitle(request.getParameter("nTitle"));
        news.setnMessage(request.getParameter("nMessage"));
        news.setnCover(fileName1);
        news.setnMenuid(request.getParameter("nMenuid"));
        Date date = new Date();
        news.setnCreattime(date);

        //设置 浏览量、评论数、点赞数 为 0
        news.setnBrowsenum(0);
        news.setnCommentnum(0);
        news.setnLikenum(0);

        newsService.insert(news);
        System.out.println("添加文章成功");

        return new ModelAndView("redirect:/fawen/textEdiot");
    }

    /* 新闻图片上传 */
    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, String> upload(@RequestParam(value="myFileName") MultipartFile file, HttpServletRequest request) {
        String separator = System.getProperty("file.separator");
        separator=separator.replaceAll("\\\\","/");
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +           request.getContextPath()+ separator; //获取项目路径+端口号 比如：http://localhost:8080/

        try {
            String filePath="";
            //获取源文件
            filePath="E:/NewsImg/" ;//存储地址，此处也可以在application.yml中配置对象用@Value("${*.**}")注解注入内容
            String filename = file.getOriginalFilename();//获取图片名
            String[] names=filename.split("\\.");//获取后缀格式
            String uploadFileName=UUID.randomUUID().toString()+"."+names[names.length-1];//生成新图片
            File targetFile = new File(filePath,uploadFileName);//目标文件
            if (!targetFile.getParentFile().exists()){
                targetFile.getParentFile().mkdirs();
            }
            //传图片一步到位
            file.transferTo(targetFile);
            Map<String, String> map = new HashMap<String, String>();
            map.put("data",basePath+"NewsImg/"+uploadFileName);//这里应该是项目路径，返回前台url
            return map;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return  null;
        }
    }

    @RequestMapping("/caogao")
    @ResponseBody
    public ModelAndView caogao(HttpServletRequest request, News news,
                               @RequestParam(value="file1",required=false) MultipartFile multipartFile)throws ServletException, IOException {
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

        System.out.println("fileName1:--------"+fileName1);

        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");

        UUID uuid= UUID.randomUUID();
        String nid =  String.valueOf(uuid);
        news.setnUserid(userId);
        news.setnState("草稿");
        news.setNId(nid);
        news.setnTitle(request.getParameter("nTitle"));
        news.setnMessage(request.getParameter("nMessage"));
        news.setnCover(fileName1);
        news.setnMenuid(request.getParameter("nMenuid"));
        Date date = new Date();
        news.setnCreattime(date);

        //设置 浏览量、评论数、点赞数 为 0
        news.setnBrowsenum(0);
        news.setnCommentnum(0);
        news.setnLikenum(0);

        newsService.insert(news);
        System.out.println("存为草稿成功");

        return new ModelAndView("redirect:/fawen/textEdiot");
    }



    String nId;
    //新闻详情页
    @RequestMapping("/details/{nId}")
    public String jumpDetail(@PathVariable("nId") String nId){
        this.nId = nId;
        return "/front/news_detail";
    }

    //获取新闻详情页内容
    @GetMapping("/getNews")
    @ResponseBody
    public ResponseBo getNews(HttpServletRequest request){
        System.out.println(nId);
        //News news = newsService.selectOne(new EntityWrapper<News>().eq("n_id",nId));
        News news = newsService.selectById(nId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nCreattime = sdf.format(news.getnCreattime());

        String userId = news.getnUserid();
        Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",userId));
        return ResponseBo.ok().put("news",news).put("user",user).put("nCreattime",nCreattime);
    }

    //获取 新闻用户信息 + 五条热闻
    @GetMapping("/getUser")
    @ResponseBody
    public ResponseBo getUser(){
        //String nId = "1";
        News news = newsService.selectOne(new EntityWrapper<News>().eq("n_id",nId));
        String userId = news.getnUserid();
        Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",userId));
        //获取用户最热的五条新闻
        List<News> newsList = newsService.getHotFiveNews(userId);
        return ResponseBo.ok().put("newsList",newsList).put("user",user);
    }

    //获得新闻评论数量
    @GetMapping("/getCommentsum")
    @ResponseBody
    public ResponseBo getCommentsum(){
        int commentSum = commentService.getCommentsum(nId);
        return ResponseBo.ok().put("commentSum",commentSum);
    }

    //获得新闻评论数据
    @GetMapping("/getComment")
    @ResponseBody
    public ResponseBo getComment(HttpServletRequest request){
        /*try {*/
            HttpSession session = request.getSession();
            String userId = (String) session.getAttribute("userId");
            String userImg = "0";//0表示未登录
            if(userId != null) {
                Users user = usersService.selectById(userId);
                userImg = "/file/showImg/" + user.getuImage();
            }
            //得到评论列表
            List<Comment> commentList = commentService.selectList(new EntityWrapper<Comment>().eq("c_newsid",nId));
            List<CommentUser> cuList = new ArrayList<>();
            for(Comment comment:commentList){
                Users user1 = usersService.selectById(comment.getcUserid());
                String imgPath = "/file/showImg/"+user1.getuImage();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String creattime = sdf.format(comment.getcCreattime());

                CommentUser cu = new CommentUser();
                cu.setComment(comment);
                cu.setUsers(user1);
                cu.setImgPath(imgPath);
                cu.setCreattime(creattime);
                cuList.add(cu);
            }

            //新闻总的评论条数
            int commentSum = commentService.getCommentsum(nId);

            return ResponseBo.ok().put("userImg",userImg).put("cuList",cuList).put("commentSum",commentSum);
        /*}catch (Exception e){
            return ResponseBo.error();
        }*/
    }

    //评论新闻
    @PostMapping("/saveComment")
    @ResponseBody
    public ResponseBo saveComment(HttpServletRequest request,String cMessage){

        Comment comment = new Comment();
        UUID id = UUID.randomUUID();
        String cId = String.valueOf(id);
        HttpSession session =request.getSession();
        String userId = (String)session.getAttribute("userId");

        comment.setCId(cId);
        comment.setcMessage(cMessage);
        comment.setcLikenum(0);
        comment.setcCreattime(new Date());
        comment.setcNewsid(nId);
        comment.setcUserid(userId);
        commentService.insert(comment);
        System.out.println("插入评论成功");

        return ResponseBo.ok().put("newsId",nId);
    }


    //获取收藏星星图片
    @GetMapping("/collectShow")
    @ResponseBody
    public ResponseBo collectShow(HttpServletRequest request){
        int flag = 3;
        //判断登录用户是否收藏过此文章

        HttpSession session = request.getSession();
        String userId1 = (String) session.getAttribute("userId");
        System.out.println("userId1:"+userId1);
        if(userId1 == null){
            flag = 3;
        }else{
            Collections collections = collectionsService.selectOne(new EntityWrapper<Collections>().
                    eq("collection_newsid",nId).eq("collection_userid",userId1));
            if(collections == null){
                flag = 0; // 0 表示没有收藏
            }else {
                flag = 1; //1 表示收藏
            }
        }
        return ResponseBo.ok().put("flag",flag);

    }

    //收藏新闻
    @PostMapping("/collect")
    @ResponseBody
    public ResponseBo collectNews(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            String userId = (String)session.getAttribute("userId");
            Collections collections = new Collections();
            collections.setCollectionNewsid(nId);
            collections.setCollectionUserid(userId);
            collectionsService.insert(collections);
            System.out.println("收藏文章成功");
            return ResponseBo.ok().put("newsId",nId);
        }catch (Exception e){
            System.out.println("收藏出错");
            return ResponseBo.error().put("newsId",nId);
        }
    }

    //取消 新闻收藏
    @PostMapping("/quxiao")
    @ResponseBody
    public ResponseBo quxiao( HttpServletRequest request){
        try{
            System.out.println("nId:"+nId);
            HttpSession session = request.getSession();
            String userId = (String)session.getAttribute("userId");
            Collections collections = collectionsService.selectOne(new EntityWrapper<Collections>().
                    eq("collection_newsid",nId).eq("collection_userid",userId));
            collectionsService.deleteById(collections.getCollectionId());
            System.out.println("取消文章收藏成功");
            return ResponseBo.ok().put("newsId",nId);
        }catch (Exception e){
            return ResponseBo.error().put("newsId",nId);
        }
    }

    //取消 新闻收藏
    @PostMapping("/quxiao1/{newsId}")
    @ResponseBody
    public ResponseBo quxiao1(@PathVariable("newsId")String newsId, HttpServletRequest request){
        try{

            HttpSession session = request.getSession();
            String userId = (String)session.getAttribute("userId");
            Collections collections = collectionsService.selectOne(new EntityWrapper<Collections>().
                    eq("collection_newsid",newsId).eq("collection_userid",userId));
            collectionsService.deleteById(collections.getCollectionId());
            System.out.println("取消文章收藏成功");
            return ResponseBo.ok();
        }catch (Exception e){
            return ResponseBo.error();
        }
    }


}
