package cn.cqjtu.lexian.dao.OrderShowTest;

import cn.cqjtu.lexian.dao.OrderExpandMapper;
import cn.cqjtu.lexian.model.OrderQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zjhfyq on 2017/7/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class OrderShow {

    @Autowired
    private OrderExpandMapper mapper;
    @Test
    public void showOrders(){
        OrderQuery query=new OrderQuery();
        //query.setAccount("xiaoma");
        query.setOrderstatus(1);
        List<cn.cqjtu.lexian.model.OrderShow> list = mapper.orderSelective(query);
        System.out.println(list.size()+"===="+list.get(0).getOrderId());


    }


}
