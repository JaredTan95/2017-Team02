package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.ShopCartExpand;
import cn.cqjtu.lexian.model.ShopcartProduction;
import cn.cqjtu.lexian.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tanjian on 2017/7/2.
 */
@Component
public interface ShopCartExpandMapper {
    List<ShopCartExpand> findAllMyShopCart(User user);

    /*DELETE  FROM shopcart_production WHERE shopcartId =?  */
    int delAllMyShopCart(ShopcartProduction shopcartProduction);
}
