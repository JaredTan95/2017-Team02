package cn.cqjtu.lexian.dao.userOrder;

import cn.cqjtu.lexian.common.util.OutOrderNum;
import cn.cqjtu.lexian.dao.UserOrderMapper;
import cn.cqjtu.lexian.model.UserOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;

/**
 * Created by tanjian on 2017/7/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UserOrderTest {
    @Autowired
    private UserOrderMapper userOrderMapper;

    @Test
    public void loopInsertDate(){
        /*Integer orderstatusId, Date orderdatetime, Date ordercancledatetime,
                     Date orderdeliverdatetime, Date orderfinishdatetime, Float ordertotalprice*/
        for (int i=0;i<8;i++){
            UserOrder userOrder=new UserOrder();
            userOrder.setOrderid(OutOrderNum.OrderNum());
            userOrder.setUserid("5baad48f5fd4426d94ba8c1d1c604923");
            userOrder.setOrderstatusId(new Random().nextInt(5)+1);
            userOrder.setOrdertotalprice(455F);
            userOrder.setOrderdatetime(new Date(2017-1900,7-1,2));
            userOrderMapper.insert(userOrder);
            System.out.println("已随机插入"+i+"条数据！");
        }
    }
}
