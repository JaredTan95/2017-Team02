package cn.cqjtu.lexian.dao.pro2cate;

import cn.cqjtu.lexian.dao.Pro2cateMapper;
import cn.cqjtu.lexian.model.Pro2cateKey;
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
 * 创建时间：2017/7/2 9:00
 * 修改人：xiaoma
 * 修改时间：2017/7/2 9:00
 * 修改备注：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class pro2cateDaoMapperTest {

    @Autowired
    private Pro2cateMapper pro2cateMapper;

    @Test
    public void insert()
    {
        Pro2cateKey pro2cateKey=new Pro2cateKey();
        pro2cateKey.setProid("1001");
        pro2cateKey.setCategoryid("6fc2fa8460aa4f66b36b9d56098e0c19");
        Assert.assertEquals(1,pro2cateMapper.insert(pro2cateKey));
    }
@Test
    public void delete()
{
    Pro2cateKey pro2cateKey=new Pro2cateKey();
    pro2cateKey.setProid("1001");
    pro2cateKey.setCategoryid("6fc2fa8460aa4f66b36b9d56098e0c19");
    Assert.assertEquals(1,pro2cateMapper.deleteByPrimaryKey(pro2cateKey));
}

}
