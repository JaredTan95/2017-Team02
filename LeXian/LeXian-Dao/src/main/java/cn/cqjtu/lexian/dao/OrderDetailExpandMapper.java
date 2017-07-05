package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDetailExpandMapper {
    List<OrderDetail> findOrderDetailByOrderId(String orderId);
}