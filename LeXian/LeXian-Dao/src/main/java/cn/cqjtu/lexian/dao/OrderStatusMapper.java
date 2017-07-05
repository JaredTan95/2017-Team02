package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public interface OrderStatusMapper {
    int deleteByPrimaryKey(Integer orderstatusId);

    int insert(OrderStatus record);

    int insertSelective(OrderStatus record);

    OrderStatus selectByPrimaryKey(Integer orderstatusId);

    int updateByPrimaryKeySelective(OrderStatus record);

    int updateByPrimaryKey(OrderStatus record);
}