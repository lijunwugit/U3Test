package cn.kgc.house.pcontroller;


import cn.kgc.house.util.sms.SentMsgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;



@Controller
@RequestMapping("/page/")
public class SmsController {

    @RequestMapping("sendCode")
    @ResponseBody
    public String sendCode(String sendPhone,HttpSession session){
        //创建消息
         int temp=(int)(Math.random()*1000)+1000;
         String msg="登入的验证码是:"+temp;
        //发送短信
         int result= SentMsgUtil.sendMsg(sendPhone,msg);

         //将随机数保存在session中
         session.setAttribute("saveocde",temp);
         return "{\"result\":"+result+"}";
    }


    @RequestMapping("loginAction2")
    @ResponseBody
    public String loginAction(String code, HttpSession session){
        //获取session的验证码
        Object o=session.getAttribute("saveocde");
        //比较验证码
        if(code.equals(o.toString())) {
            return "登录成功";
        }else
            return "登录失败";
    }
}
