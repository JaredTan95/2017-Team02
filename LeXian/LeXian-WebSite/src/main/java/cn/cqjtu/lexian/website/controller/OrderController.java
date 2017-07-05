package cn.cqjtu.lexian.website.controller;

import cn.cqjtu.lexian.model.OrderExpand;
import cn.cqjtu.lexian.model.OrderQuery;
import cn.cqjtu.lexian.model.User;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 订单控制器
 * Created by zjhfyq on 2017/7/1.
 */
@RequestMapping("/user/order")
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 添加订单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Message add(OrderExpand orderExpand,String token,HttpSession session) {
        if(token==null||token.length()<=0||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限，未登录");
        }
        User user= (User) session.getAttribute(token);
        orderExpand.setUserid(user.getUserid());
        return orderService.addOneOrder(orderExpand);
    }


    /**
     * 取消订单
     *
     * @param token   权限认证
     * @param orderId 订单编号
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cancle",method = {RequestMethod.POST})
    public Message cancle(String token, String orderId,HttpSession session) {
        if(token==null||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        return orderService.cancleOrder(orderId);
    }


    /**
     * 分页查询订单
     *
     * @param query    查询条件
     * @param token 权限认证
     * @return
     */
    @RequestMapping(value = "/query",method = {RequestMethod.POST})
    @ResponseBody
    public Message query(OrderQuery query, String token, HttpSession session) {
        if(token==null||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        query.setAccount(((User)session.getAttribute(token)).getUseraccount());
        return orderService.findAllMyOrder(query);
    }


    /**
     * 查询订单详情
     * @param token
     * @param orderId
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryDetail",method = {RequestMethod.POST})
    public  Message queryDetail(String token,String orderId,HttpSession session){
        if(token==null||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        Message message = orderService.findOrderDetailByOrderId(orderId);
        return  message;
    }


    /**
     * 支付
     * @param token
     * @param orderId
     * @param session
     * @return
     */
    @RequestMapping(value = "pay",method = {RequestMethod.POST})
    @ResponseBody
    public  Message pay(String token,String orderId,HttpSession session){
        if(token==null||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        return  orderService.payOrder(orderId);
    }







}
