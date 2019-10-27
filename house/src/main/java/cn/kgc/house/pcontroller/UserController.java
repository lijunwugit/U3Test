package cn.kgc.house.pcontroller;

import cn.kgc.house.entity.Users;
import cn.kgc.house.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller(value ="userController2" )
@RequestMapping("/page/")
public class UserController {

    @Autowired
    private UsersService userService;

    //注册
    @RequestMapping("reg")
    public String reg(Users users){
        int temp=userService.addUser(users);
        if(temp>0)
        return "/page/login.jsp";
        else
            return "/page/regs.jsp";
    }

    //检查用户名
    @RequestMapping("checkName")
    @ResponseBody
    public String checkName(String name){
         //调用业务
        int falg=userService.selectByName(name);
        return "{\"result\":"+falg+"}";
    }

    //注册
    @RequestMapping("loginAction")
    public String loginAction(String name, String password, HttpSession session){
        Users user=userService.login(name,password);
        System.out.println(user);
        if(user!=null) {
           //就使用session保存登入的人
            session.setAttribute("userinfo",user);
            //设置session的有效期
            session.setMaxInactiveInterval(600);  //10分钟
            return "redirect:/page/getUserHouse.do";
        }else
            return "/page/login.jsp";  //登入页
    }


}
