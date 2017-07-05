package cn.cqjtu.lexian.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tanjian on 2017/6/29.
 * 后台管理首页控制器
 */
@Controller
@RequestMapping("/")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("")
    public ModelAndView homePage(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/WEB-INF/views/index.jsp");
        return mav;
    }

}
