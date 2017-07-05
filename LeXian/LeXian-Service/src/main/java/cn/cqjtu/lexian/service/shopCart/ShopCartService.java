package cn.cqjtu.lexian.service.shopCart;

import cn.cqjtu.lexian.model.ShopcartProduction;
import cn.cqjtu.lexian.model.User;
import cn.cqjtu.lexian.model.message.Message;

/**
 * Created by tanjian on 2017/7/1.
 * 购物车业务接口
 */
public interface ShopCartService {
    /**
     * 初始化购物车
     * 主要用于用户注册账户的时候绑定购物车,请在用户注册服务中调用该服务。
     *
     * @param user the user
     * @return the message
     */
    Message initShopCart(User user);

    /**
     * Add 2 shopcart .
     *
     * @param shopcartProduction the shopcartProduction
     * @return the message
     */
    Message add2ShopCart(ShopcartProduction shopcartProduction);

    /**
     * Find all my shopCart .
     *
     * @return the message
     */
    Message findAllMyShopCart(User user);

    /**
     * Find one my shopCart.
     *
     * @param shopcartProduction the shopcartProduction
     * @return the message
     */
    Message findOneMyShopCart(ShopcartProduction shopcartProduction);

    /**
     * Del one my shopCart.
     *
     * @param shopcartProduction the shopcartProduction
     * @return the message
     */
    Message delOneMyShopCart(ShopcartProduction shopcartProduction);

    /**
     * Del all my shopCart.
     *
     * @param shopcartProduction the shopcartProduction
     * @return the message
     */
    Message delAllMyShopCart(ShopcartProduction shopcartProduction);


    Message updateAmount(ShopcartProduction shopcartProduction);


    Message queryAll(String userId);



    Message cancleProductionByProductionId(ShopcartProduction shopcartProduction);
}
