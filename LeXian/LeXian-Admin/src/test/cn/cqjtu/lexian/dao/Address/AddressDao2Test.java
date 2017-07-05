package cn.cqjtu.lexian.dao.Address;

import cn.cqjtu.lexian.dao.AddressMapper;
import cn.cqjtu.lexian.model.Address;
import cn.cqjtu.lexian.model.AddressKey;
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
 * 创建时间：2017/7/1 14:53
 * 修改人：xiaoma
 * 修改时间：2017/7/1 14:53
 * 修改备注：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AddressDao2Test {

    @Autowired
    private AddressMapper addressMapper;


    @Test
    public void insert() {
        Address address = new Address();
        address.setUserid("1003");
        address.setAddressid("1001");
        address.setAddressphone("18184720998");
        address.setAddressname("小连");
        address.setAddressstr("重庆市南岸区");
        address.setAddresspost("123456");
        Assert.assertEquals(1, addressMapper.insert(address));
    }

    @Test
    public void delete() {
        AddressKey addressKey = new AddressKey();
        addressKey.setAddressid("1001");
        addressKey.setUserid("1003");
        Assert.assertEquals(1, addressMapper.deleteByPrimaryKey(addressKey));
    }

    @Test
    public void update() {
        Address address = new Address();
        address.setUserid("1003");
        address.setAddressid("1001");
        address.setAddressphone("18184720998");
        address.setAddressname("小马");
        address.setAddressstr("重庆市南岸区");
        address.setAddresspost("123456");
        Assert.assertEquals(1, addressMapper.updateByPrimaryKey(address));
    }

    @Test
    public void select() {
        Address address = new Address();
        AddressKey addressKey = new AddressKey();
        addressKey.setAddressid("1001");
        addressKey.setUserid("1003");
        Assert.assertEquals("重庆市南岸区", addressMapper.selectByPrimaryKey(addressKey).getAddressstr());
    }
}
