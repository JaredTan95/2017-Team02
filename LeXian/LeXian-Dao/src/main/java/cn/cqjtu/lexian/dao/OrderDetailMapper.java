package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.OrderDetail;
import org.springframework.stereotype.Component;

@Component
public interface OrderDetailMapper {
    int deleteByPrimaryKey(String orderdetailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String orderdetailId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}