package cn.cqjtu.lexian.service.order;

import cn.cqjtu.lexian.model.OrderExpand;
import cn.cqjtu.lexian.model.OrderQuery;
import cn.cqjtu.lexian.model.UserOrder;
import cn.cqjtu.lexian.model.message.Message;

/**
 * Created by tanjian on 2017/7/1.
 * 订单业务接口
 */

public interface OrderService {
    /**
     * 添加一笔订单
     *
     * @param userOrder the user order
     * @return the message
     */
    Message addOneOrder(OrderExpand userOrder);

    /**
     * 查找一笔订单
     *
     * @param userOrder
     * @return the message
     */
    Message findOneOrder(UserOrder userOrder);

    /**
     * 查找用户所有订单
     *
     * @param query
     * @return the message
     */
    Message findAllMyOrder(OrderQuery query);

    /**
     * 取消一笔订单
     *
     * @param userOrder the user order
     * @return the message
     */
    Message cancelOneOrder(UserOrder userOrder);

    /**
     * 支付一笔订单
     *
     * @param userOrder the user order
     * @return the message
     */
    Message pay4OneOrder(UserOrder userOrder);


    /**
     * 根据查询条件动态查询订单信息
     *
     * @param query OrderQuery
     * @return message
     */
    Message orderSelective(OrderQuery query);


    Message findOrderDetailByOrderId(String orderId);

    Message payOrder(String orderId);

    Message cancleOrder(String orderId);
}
