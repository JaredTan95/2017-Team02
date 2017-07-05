package cn.cqjtu.lexian.website.controller;

import cn.cqjtu.lexian.model.Category;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品分类控制器
 * Created by zjhfyq on 2017/7/1.
 */
@RequestMapping("/user/category")
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/query")
    public Message query(){
        return categoryService.findAllCate();
    }

    @RequestMapping(value = "/queryOne")
    @ResponseBody
    public Message queryOne(String cateId){
        Category category=new Category();
        category.setCategoryid(cateId);
        return categoryService.findOneCate(category);
    }

}
