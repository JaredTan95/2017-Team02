package cn.cqjtu.lexian.admin;

import cn.cqjtu.lexian.model.Category;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/**
 * 商品分类控制器
 * Created by zjhfyq on 2017/6/30.
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    /**
     * 添加商品分类
     * @return
     */
    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    @ResponseBody
    public Message addCategory(Category category, String token, HttpSession session) throws UnsupportedEncodingException {
        if(token==null||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        System.out.println("添加商品分类："+category.getCategorytitle());
        return categoryService.addOneCata(category);
    }


    /**
     * 修改商品分类信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public  Message updateCategory(Category category,String token,HttpSession session){
        if(token==null||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        return categoryService.updateOneCate(category);
    }


    @ResponseBody
    @RequestMapping("/query")
    public  Message queryCategory(String token,HttpSession session){
        if(token==null||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        return  categoryService.findAllCate();
    }






}
