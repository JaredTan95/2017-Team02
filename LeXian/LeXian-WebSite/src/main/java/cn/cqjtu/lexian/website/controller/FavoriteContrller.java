package cn.cqjtu.lexian.website.controller;

import cn.cqjtu.lexian.model.message.Message;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * 商品收藏控制器
 * Created by zjhfyq on 2017/7/1.
 */

@RequestMapping("/user/favorite")
@Controller
public class FavoriteContrller {


    /**
     * 添加收藏
     * @param token  权限认证
     * @param productionId  商品ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method ={RequestMethod.POST})
    public Message add(String token,String productionId){
        return  Message.getSuccessMessage();
    }


    /**
     * 取消收藏
     * @param token  权限认证
     * @param productionId 商品ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cnacle",method = {RequestMethod.POST})
    public  Message cancle( String token, String productionId){
        return Message.getSuccessMessage();
    }


    /**
     * 查询收藏
     * @param pn  页数
     * @param token 权限认证
     * @return
     */
    @ResponseBody
    @RequestMapping("/query")
    public  Message query(@RequestParam(value = "pn",defaultValue = "1")Integer pn,String token){
        return Message.getSuccessMessage();
    }














}
