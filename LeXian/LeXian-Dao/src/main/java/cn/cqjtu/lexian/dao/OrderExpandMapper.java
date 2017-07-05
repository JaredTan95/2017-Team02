package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.OrderQuery;
import cn.cqjtu.lexian.model.OrderShow;
import cn.cqjtu.lexian.model.message.Message;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zjhfyq on 2017/7/1.
 */
@Component
public interface OrderExpandMapper {


    public List<OrderShow> orderSelective(OrderQuery query);



    public  int payOrder(String orderId);


    int cancleOrder(String orderId);
}
