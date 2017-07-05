package cn.cqjtu.lexian.dao.shopcart;

import cn.cqjtu.lexian.dao.ShopcartMapper;
import cn.cqjtu.lexian.model.Shopcart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 项目名称：LeXian
 * 类描述：
 * 创建人：xiaoma
 * 创建时间：2017/7/2 9:49
 * 修改人：xiaoma
 * 修改时间：2017/7/2 9:49
 * 修改备注：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class shopcartDaoTest {
    @Autowired
    private ShopcartMapper shopcartMapper;

    @Test
    public void inset() {
        Shopcart shopcart = new Shopcart();
        for (int i = 0; i < 50; i++) {
            shopcart.setUserid("1003");
            shopcart.setShopcartid("" + (1002 + i));
            shopcart.setProductionKindAmount(i + 1);
            Assert.assertEquals(1, shopcartMapper.insert(shopcart));
        }
    }

    @Test
    public void delete() {
        Assert.assertEquals(1, shopcartMapper.deleteByPrimaryKey("1003"));
    }

    @Test
    public void select() {
        Assert.assertEquals("1003", shopcartMapper.selectByPrimaryKey("1002").getUserid());

    }

    @Test
    public void update()
    {
        Shopcart shopcart = new Shopcart();
            shopcart.setUserid("1003");
            shopcart.setShopcartid("1008");
            shopcart.setProductionKindAmount(4);
        Assert.assertEquals(1,shopcartMapper.updateByPrimaryKey(shopcart));
    }
}

