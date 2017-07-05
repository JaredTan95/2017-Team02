package cn.cqjtu.lexian.website.controller;

import cn.cqjtu.lexian.dao.AddressMapper;
import cn.cqjtu.lexian.model.Address;
import cn.cqjtu.lexian.model.User;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 收货人地址控制器
 * Created by zjhfyq on 2017/7/3.
 */
@Controller
@RequestMapping("/user/address")
public class AddressController {


    @Autowired
    private AddressService addressService;

    @ResponseBody
    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public Message add(Address address, String token, HttpSession session){
        if(token==null||token.length()<=0||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        address.setUserid(((User)session.getAttribute(token)).getUserid());
        return addressService.addAddress(address);
    }


    @RequestMapping("/queryAll")
    @ResponseBody
    public  Message query(String token,HttpSession session){
        if(token==null||token.length()<=0||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        User user= (User) session.getAttribute(token);
        Message message = addressService.findAll(user.getUserid());
        return message;
    }

    @RequestMapping("/queryOne")
    @ResponseBody
    public  Message query(String token,String addressid,HttpSession session){
        if(token==null||token.length()<=0||session.getAttribute(token)==null){
            return Message.getSuccessMessage().put("error","没有权限");
        }
        Message message = addressService.findOne(addressid);
        return message;
    }


}
