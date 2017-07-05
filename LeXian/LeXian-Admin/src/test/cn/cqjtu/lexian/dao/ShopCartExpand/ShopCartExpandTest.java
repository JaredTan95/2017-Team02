package cn.cqjtu.lexian.dao.ShopCartExpand;

import cn.cqjtu.lexian.dao.ShopCartExpandMapper;
import cn.cqjtu.lexian.model.ShopCartExpand;
import cn.cqjtu.lexian.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by tanjian on 2017/7/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class ShopCartExpandTest {
    @Autowired
    private ShopCartExpandMapper shopCartExpandMapper;
    @Test
    public void findAllMyShopCart(){
        User user=new User();
        user.setUserid("1003");
        List<ShopCartExpand> lists=shopCartExpandMapper.findAllMyShopCart(user);
        System.out.println("------>>>>>"+lists.size());
        for(ShopCartExpand item:lists){
            System.out.println(item.toString());
        }
    }
}
