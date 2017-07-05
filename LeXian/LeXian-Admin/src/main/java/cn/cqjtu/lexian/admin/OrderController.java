package cn.cqjtu.lexian.admin;

import cn.cqjtu.lexian.model.Admin;
import cn.cqjtu.lexian.model.OrderQuery;
import cn.cqjtu.lexian.model.User;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 订单控制器
 * Created by zjhfyq on 2017/7/1.
 */
@Controller
@RequestMapping("/admin/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/query")
    public Message query(String token, OrderQuery query, HttpSession session){

        if(token==null||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        return orderService.orderSelective(query);
    }


}
