package cn.cqjtu.lexian.website.controller;

import cn.cqjtu.lexian.common.util.CheckRegex;
import cn.cqjtu.lexian.common.util.MailUtils;
import cn.cqjtu.lexian.common.util.UUidUtils;
import cn.cqjtu.lexian.common.util.VerificationCodeUtil;
import cn.cqjtu.lexian.model.Admin;
import cn.cqjtu.lexian.model.User;
import cn.cqjtu.lexian.model.UserExpand;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Enumeration;

/**
 * 用户控制器
 * Created by zjhfyq on 2017/6/30.
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 登录，正确登录返回token
     * @return
     */
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ResponseBody
    public Message login(User user, HttpSession session){

        //防止多次登录
        Enumeration<String> attributeNames = session.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String name=attributeNames.nextElement();
            System.out.println(name);
            if(name.length()==64){//说明name是token的值
                System.out.println("删除token为"+name+"的用户"+((User)session.getAttribute(name)).getUseraccount());
                session.removeAttribute(name);
            }
        }
        //重新登录


        Message message = userService.login(user);
        User userq = (User) message.getMap().get("user");
        if(userq!=null){
            session.setAttribute(message.getMap().get("token").toString(),userq);
            User lastUser=new User();
            lastUser.setUseraccount(userq.getUseraccount());
            lastUser.setUsermail(userq.getUsermail());
            lastUser.setUserid(userq.getUserid());
            lastUser.setShopcartid(userq.getShopcartid());
            lastUser.setUsername(userq.getUsername());
            message.put("user",lastUser);
        }
        return message ;
    }



    @ResponseBody
    @RequestMapping(value = "/register",method = {RequestMethod.POST})
    public  Message register(UserExpand userExpand,HttpSession session){
        if(userExpand.getVerificationCode()==null||userExpand.getVerificationCode().length()!=6){
            return Message.getSuccessMessage().put("error","验证码不能为空");
        }
        if(session.getAttribute("verificationCode")==null){
            return Message.getSuccessMessage().put("error","验证码不正确");
        }
        if(!session.getAttribute("verificationCode").toString().equals(userExpand.getVerificationCode())){
            return Message.getSuccessMessage().put("error","验证码不正确");
        }
        session.removeAttribute("verificationCode");//保证一次验证码只能用一次
        return userService.register(userExpand);
    }


    /**
     * 修改密码
     * @param verificationCode
     * @param account
     * @param newPassword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changePssword" ,method = {RequestMethod.POST})
    public Message changePassword(String verificationCode,String account,String newPassword){
        return Message.getSuccessMessage();
    }

    /**
     * 根据邮箱获取验证码
     * @param mail
     * @return
     */
    @ResponseBody
    @RequestMapping("/getVerificationCodeByMail")
    public Message getVerificationCode(String mail,HttpSession session){
        Long now=new Date().getTime();
        if(session.getAttribute("lastTime")!=null){
            Long last= (Long) session.getAttribute("lastTime");
            if (now-last<=60000){
                return Message.getSuccessMessage().put("error","请"+(60-(now-last)/1000)+"秒后尝试");
            }
        }


        if(mail==null||mail.length()<=0|| !CheckRegex.checkMail(mail)){
            return  Message.getSuccessMessage().put("error","邮箱格式不正确");
        }
        String code= VerificationCodeUtil.getCode6();
        session.setAttribute("verificationCode",code);


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始发送邮件");
                MailUtils.sendMail(mail,code);
                System.out.println("发送邮件完成");
            }
        }).start();

        session.setAttribute("lastTime",new Date().getTime());
        return  Message.getSuccessMessage().put("success","验证码发送成功");
    }



    /**
     * 根据账户名获取验证码
     * @param userAccount
     * @return
     */
    @ResponseBody
    @RequestMapping("/getVerificationCodeByUserAccount")
    public Message getVerificationCode(String userAccount,HttpSession session,String noUse){
        Long now=new Date().getTime();
        if(session.getAttribute("lastTime")!=null){
            Long last= (Long) session.getAttribute("lastTime");
            if (now-last<=60000){
                return Message.getSuccessMessage().put("error","请"+(60-(now-last)/1000)+"秒后尝试");
            }
        }

        if(userAccount==null||userAccount.length()<=0){
            return  Message.getSuccessMessage().put("error","邮箱格式不正确");
        }
        Message message = userService.findUserByuserAccount(userAccount);
        if(message.getMap().get("user")==null){
            return message;
        }
        User user= (User) message.getMap().get("user");
        String code= VerificationCodeUtil.getCode6();
        session.setAttribute("verificationCode",code);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始发送邮件");
                MailUtils.sendMail(user.getUsermail(),code);
                System.out.println("发送邮件完成");
            }
        }).start();

        session.setAttribute("lastTime",new Date().getTime());
        return  Message.getSuccessMessage().put("success","验证码发送成功");
    }





    /**
     * 登录后再次获取信息
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getInfo")
    public Message getInfo(HttpSession session){
        Message message=Message.getFailedMessage().put("error","没有登录");
        //获取信息
        Enumeration<String> attributeNames = session.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String name=attributeNames.nextElement();
            System.out.println(name);
            if(name.length()==64){//说明name是token的值
                message=Message.getSuccessMessage().put("user",session.getAttribute(name));
                break;
            }
        }
        return message;
    }




}
