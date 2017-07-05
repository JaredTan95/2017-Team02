package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.OrderAddress;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zjhfyq on 2017/7/3.
 */
@Component
public interface OrderAddressMapper {

    int addOrderAddress(OrderAddress address);

    List<OrderAddress> findOrderAddressByOrderId(String orderId);

}
