package cn.cqjtu.lexian.website.controller;

import cn.cqjtu.lexian.common.util.UUidUtils;
import cn.cqjtu.lexian.model.ShopcartProduction;
import cn.cqjtu.lexian.model.User;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.shopCart.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *
 *
 * 购物车控制器
 * Created by zjhfyq on 2017/7/1.
 */
@RequestMapping("/user/shopcart")
@Controller
public class ShopcartController {


    @Autowired
    private ShopCartService shopCartService;

    /**
     * 添加商品到购物车
     * @param token 权限认证
     * @param productionId 商品ID
     * @param amount 商品数量
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public Message add(String token, String productionId, Integer amount, HttpSession session){
        if(token==null||session.getAttribute(token)==null){
            return  Message.getSuccessMessage().put("error","没有权限");
        }
        ShopcartProduction sp=new ShopcartProduction();
        try {
            if (amount <= 0) {
                amount = 1;
            }
            sp.setSpId(UUidUtils.uuid().replaceAll("-", ""));
            sp.setProductionAmount(amount);
            sp.setProductionId(productionId);
            User user = (User) session.getAttribute(token);
            sp.setShopcartid(user.getUserid());
        } catch (Exception e) {
            e.printStackTrace();
            return Message.getSuccessMessage().put("error", "参数不合法");
        }
        return shopCartService.add2ShopCart(sp);
    }


    /**
     * 删除购物车中的商品
     * @param token 权限认证
     * @param productionId 商品ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cancle",method = {RequestMethod.POST})
    public  Message cancle(String token,String productionId,HttpSession session){
        if(token==null||session.getAttribute(token)==null){
            return  Message.getSuccessMessage().put("error","没有权限");
        }
        ShopcartProduction sp=new ShopcartProduction();
        sp.setProductionId(productionId);
        User user= (User) session.getAttribute(token);
        sp.setShopcartid(user.getShopcartid());
        return  shopCartService.cancleProductionByProductionId(sp);
    }


    /**
     * 修改购物车中的某个商品的数量
     * @param token
     * @param productionId
     * @param amount
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public Message update(String token,String productionId,Integer amount,HttpSession session){
        if(token==null||session.getAttribute(token)==null){
            return  Message.getSuccessMessage().put("error","没有权限");
        }
        ShopcartProduction sp=new ShopcartProduction();
        if(amount<=0){
            amount=1;
        }
        sp.setProductionAmount(amount);
        sp.setProductionId(productionId);
        User user= (User) session.getAttribute(token);
        sp.setShopcartid(user.getShopcartid());
        return shopCartService.updateAmount(sp);
    }


    /**
     * 查询购物车
     * @param token  权限认证
     * @return
     */
    @ResponseBody
    @RequestMapping("/query")
    public Message query(String token,HttpSession session ){
        if(token==null||session.getAttribute(token)==null){
            return  Message.getSuccessMessage().put("error","没有权限");
        }
        User user= (User) session.getAttribute(token);
        return shopCartService.queryAll(user.getUserid());
    }







}
