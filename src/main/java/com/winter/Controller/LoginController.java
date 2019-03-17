package com.winter.Controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.winter.model.Users;
import com.winter.service.FansService;
import com.winter.service.UsersService;
import com.winter.utils.ResponseBo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 马圳彬
 * @version 1.0
 * @description springboot-mybatis-demo-master
 * @date 2019/2/21 21:29
 **/
@Controller
@RequestMapping("/login")
public class LoginController extends HttpServlet {

    @Autowired
    public UsersService usersService;
    @Autowired
    private FansService fansService;

    @RequestMapping("/index")
    public String index(){
        return "/front/login";
    }


    @RequestMapping("/judge")
    @ResponseBody
    public int judge(HttpServletRequest request,String uPhone,String uPassword){
        Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_phone",uPhone));
        if( user == null ){
            return 0;//说明帐号不存在
        }else{
            if(user.getuType( ).equals("管理员")){
                return 3;
            }

            Users user1 = usersService.selectOne(new EntityWrapper<Users>().eq("u_phone",uPhone).eq("u_password",uPassword));
            if(user1 == null){
                return 1;//说明密码错误
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("userId",user1.getUId());
                String id = (String)session.getAttribute("userId");
                System.out.println(id);

                return 2;
            }
        }
    }


    @GetMapping("/getUserinfo")
    @ResponseBody
    public ResponseBo getUserInfo(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            String id = (String)session.getAttribute("userId");
            Users user = usersService.selectById(id);
            String imgPath = "/file/showImg/"+user.getuImage();
            return ResponseBo.ok().put("user",user).put("imgPath",imgPath);
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public ResponseBo getUser(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            String id = (String)session.getAttribute("userId");
            System.out.println("/getUser:"+id);
            Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",id));

            String imgPath = "/file/showImg/"+user.getuImage();

            //获得关注者、粉丝数量
            int userCount = fansService.getUserCount(id);
            int fansCount = fansService.getFansCount(id);
            return ResponseBo.ok().put("user",user).put("userCount",userCount).put("fansCount",fansCount).put("imgPath",imgPath);

        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public ResponseBo getUsers(HttpServletRequest request){
        System.out.println("getUsers!!");
        try{
            HttpSession session = request.getSession();
            String id = (String)session.getAttribute("userId");

            Users user = usersService.selectOne(new EntityWrapper<Users>().eq("u_id",id));
            return ResponseBo.ok().put("user",user);

        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    //退出登录
    @RequestMapping("/out")
    @ResponseBody
    public ModelAndView loginout(HttpServletRequest request){
       try {
           HttpSession session = request.getSession();
           session.removeAttribute("userId");
           return new ModelAndView("redirect:/front/hotpoint");
       }catch (Exception e){
           return new ModelAndView("redirect:/front/hotpoint");
       }
    }
}
