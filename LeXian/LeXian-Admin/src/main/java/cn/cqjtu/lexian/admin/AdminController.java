package cn.cqjtu.lexian.admin;

import cn.cqjtu.lexian.model.Admin;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.admin.AdminService;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by zjhfyq on 2017/6/30.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 页面跳转请求
     * @return
     */
    @RequestMapping(value = "/loginview" ,method = {RequestMethod.GET})
    public String login(){
        return "/login.html";
    }

    @RequestMapping(value = "/index" ,method = {RequestMethod.GET})
    public String index(){
        return "/WEB-INF/views/index.html";
    }

    @RequestMapping(value = "/indexmain",method = {RequestMethod.GET})
    public String indexmain(){
        return "/WEB-INF/views/index_v1.html";
    }

    @RequestMapping(value = "/category",method = {RequestMethod.GET})
    public String category(){
        return "/WEB-INF/views/category.html";
    }

    @RequestMapping(value = "/categoryAdd",method = {RequestMethod.GET})
    public String categoryAdd(){
        return "/WEB-INF/views/categoryAdd.html";
    }

    @RequestMapping(value = "/productionIndex",method = {RequestMethod.GET})
    public String productionIndex(){
        return "/WEB-INF/views/productionIndex.html";
    }

    @RequestMapping(value = "/productionAdd",method = {RequestMethod.GET})
    public String productionAdd(){
        return "/WEB-INF/views/productionAdd.html";
    }

    @RequestMapping(value = "/orderIndex",method = {RequestMethod.GET})
    public String orderIndex(){
        return "/WEB-INF/views/orderIndex.html";
    }

    /**
     * 登录
     * @param admin
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/login")
    public  Message login(Admin admin, HttpSession session){

        //防止多次登录
        Enumeration<String> attributeNames = session.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String name=attributeNames.nextElement();
            System.out.println(name);
            if(name.length()==64){//说明name是token的值
                System.out.println("删除token为"+name+"的管理员"+((Admin)session.getAttribute(name)).getAdminaccount());
                session.removeAttribute(name);
                break;
            }
        }
        //重新登录
        Message message = adminService.Validate(admin);
        Admin adminq = (Admin) message.getMap().get("admin");
        if(adminq!=null){
            session.setAttribute(message.getMap().get("token").toString(),adminq);
            Admin lastadmin=new Admin();
            lastadmin.setAdminid(adminq.getAdminid());
            lastadmin.setAdminaccount(adminq.getAdminaccount());
            lastadmin.setAdminname(adminq.getAdminname());
            message.put("admin",lastadmin);
        }
        return message ;
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
                message=Message.getSuccessMessage().put("admin",session.getAttribute(name));
                break;
            }
        }
        return message;
    }


    @RequestMapping(value = "/getQiNiuUpToken")
    @ResponseBody
    public String uptoken(HttpSession session){
        String accessKey = "5c8XqP_Hene9ZnSCs6_akY6U0E-FBW84s1cQoVLf";
        String secretKey = "7Yb7n4i8BMFgzZ2SgiC8-JXUpPpr3QfxM0i1HUnz";
        String bucket = "testimg";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println("生成upToken："+upToken);
        return upToken;
    }
}
