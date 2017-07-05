package cn.cqjtu.lexian.website.controller;

import cn.cqjtu.lexian.model.ProductionQuery;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.producation.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *
 * 商品控制器
 * Created by zjhfyq on 2017/7/1.
 */
@RequestMapping("/user/production")
@Controller
public class ProductionController {


    @Autowired
    private ProductionService productionService;
    /**
     * 查询商品
     * @return
     */
    @ResponseBody
    @RequestMapping("/query")
    public Message query( HttpSession session,ProductionQuery query){
        if(query==null){
            query=new ProductionQuery();
        }
        return productionService.findProductionByProductionQuery(query);
    }

    /**
     * 根据商品分类查询商品
     * @param pn
     * @param categoryId
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryByCategory")
    public  Message query(@RequestParam(value = "pn",defaultValue = "1")Integer pn,String categoryId){
        return  Message.getFailedMessage();
    }


    @ResponseBody
    @RequestMapping("/queryByName")
    public Message queryByName(@RequestParam(value = "pn",defaultValue = "1")Integer pn,String proName){
        return  Message.getSuccessMessage();
    }

}
