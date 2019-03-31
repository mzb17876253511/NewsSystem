package com.winter.Controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.winter.model.*;
import com.winter.model.other.FansUsers;
import com.winter.model.other.NewsCollections;
import com.winter.model.other.NewsUsers;
import com.winter.service.*;
import com.winter.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
 * @date 2019/3/11 21:25
 **/
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private CollectionsService collectionsService;
    @Autowired
    private FansService fansService;
    @Autowired
    private NewsuserService newsuserService;

    @GetMapping("/data")
    @ResponseBody
    public ResponseBo getPersondata(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            String id = (String)session.getAttribute("userId");
              //String id = "2";
            //获得用户信息
            Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",id));

                //获得已发表的文章列表
                List<News> newsList = newsService.selectList(new EntityWrapper<News>().eq("n_userid", id).eq("n_state", "已发表"));
                List<NewsUsers> nuList = new ArrayList<>();
                for (News news : newsList) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String creattime = sdf.format(news.getnCreattime());

                    NewsUsers nu = new NewsUsers();
                    nu.setCreattime(creattime);
                    nu.setNews(news);
                    nuList.add(nu);
                }

            //获得收藏文章列表
            List<Collections> collectionList = collectionsService.selectList(new EntityWrapper<Collections>().eq("collection_userid",id));
            List<NewsCollections> ncList = new ArrayList<>();
            for(Collections collection:collectionList){
                String newsId = collection.getCollectionNewsid();
                News news = newsService.selectOne(new EntityWrapper<News>().eq("n_id",newsId));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String creattime = sdf.format(news.getnCreattime());

                NewsCollections nc = new NewsCollections();
                nc.setCollections(collection);
                nc.setNews(news);
                nc.setCreattime(creattime);
                ncList.add(nc);
            }
            //获得 关注用户列表
            List<Fans> fansList = fansService.selectList(new EntityWrapper<Fans>().eq("fans_id",id));
            List<FansUsers> fuList = new ArrayList<>();
            for(Fans fans:fansList){
                String userId = fans.getUserId();
                Users users = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",userId));

                FansUsers fu = new FansUsers();
                fu.setFans(fans);
                fu.setUser(users);
                fuList.add(fu);
            }
            //获得 粉丝用户列表
            List<Fans> fansList1 = fansService.selectList(new EntityWrapper<Fans>().eq("user_id",id));
            List<FansUsers> fuList1 = new ArrayList<>();
            for(Fans fans:fansList1){
                String fansId = fans.getFansId();
                Users users = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",fansId));

                FansUsers fu1 = new FansUsers();
                fu1.setFans(fans);
                fu1.setUser(users);
                fuList1.add(fu1);
            }
            //获得 粉丝总数 和 关注总数
            int fansCount = fansService.getFansCount(id);
            int userCount = fansService.getUserCount(id);

            return ResponseBo.ok().put("user",user).put("newsList",nuList)
                    .put("newsCollection",ncList).put("fansList",fuList)
                    .put("userList",fuList1).put("fansCount",fansCount).put("userCount",userCount);
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    @PostMapping("/apply")
    @ResponseBody
    public ResponseBo ceshi(HttpServletRequest request,String uName,String uIntro,String uUsername,String uPhone,String uIdcard,
                            @RequestParam( value="files",required=false) MultipartFile multipartFile)throws IllegalStateException, IOException {
        System.out.println("成功进来："+uName);

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


            HttpSession session = request.getSession();
             String id = (String)session.getAttribute("userId");

            Newsuser nu = new Newsuser();
            nu.setNewsuserFlag(0);//0 表示还未处理， 1 表示通过，2 表示 未通过
            nu.setNewsuserUname(uUsername);// 姓名
            nu.setNewsuserPhone(uPhone);//手机号码
            nu.setNewsuserIdcard(uIdcard);//身份证号码
            nu.setNewsuserUserid(id);//用户id

            nu.setNewsuserApplytime(new Date());//申请时间
            nu.setNewsuserImage(fileName1);//帐号头像
            nu.setNewsuserIntro(uIntro);//帐号简介
            nu.setNewsuserName(uName);//帐号姓名

            newsuserService.insert(nu);
            return ResponseBo.ok();

    }
}
