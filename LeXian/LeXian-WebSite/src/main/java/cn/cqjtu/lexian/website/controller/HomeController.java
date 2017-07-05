package cn.cqjtu.lexian.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tanjian on 2017/6/28.
 */
@Controller
@RequestMapping("/")
public class HomeController {

/*
    @RequestMapping("")
    public ModelAndView homePage(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/views/index.jsp");
        return  mav;
    }*/

    @RequestMapping(value = "")
    public String index() {
        return "index.html";
    }
}
