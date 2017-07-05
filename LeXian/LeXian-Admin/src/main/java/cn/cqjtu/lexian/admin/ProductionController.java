package cn.cqjtu.lexian.admin;

import cn.cqjtu.lexian.model.Production;
import cn.cqjtu.lexian.model.ProductionQuery;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.producation.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 后台商品控制类
 * Created by zjhfyq on 2017/6/30.
 */
@Controller
@RequestMapping("/admin/production")
public class ProductionController {


    @Autowired
    private ProductionService productionService;


    /**
     * 添加商品
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public Message addProduction(String token, Production production ,HttpSession session){
        if(token==null||token.length()<=0||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        return productionService.addOneProduction(production);
    }


    /**
     * 下架商品
     * @return
     */
    @ResponseBody
    @RequestMapping("/cancle")
    public  Message cancleProduction(String token,String productionId,HttpSession session){
        if(token==null||token.length()<=0||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        return productionService.cancleProduction(productionId);
    }


    /**
     * 查询商品
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query")
    public  Message queryProduction(ProductionQuery query, String token, HttpSession session){
        if(token==null||token.length()<=0||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        if(query==null){
            query=new ProductionQuery();
        }
        return productionService.findProductionByProductionQuery(query);
    }


    @ResponseBody
    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public Message updateProduction(){
        return  Message.getSuccessMessage();
    }





}
