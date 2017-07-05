package cn.cqjtu.lexian.dao.admin;

import cn.cqjtu.lexian.dao.AdminExpandMapper;
import cn.cqjtu.lexian.dao.AdminMapper;
import cn.cqjtu.lexian.model.Admin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tanjian on 2017/6/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AdminDao2Test {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminExpandMapper adminExpandMapper;

    @Test
    public void select() {
        Admin admin = new Admin();
        admin = adminMapper.selectByPrimaryKey("1001");
        Assert.assertEquals("xiaoma", admin.getAdminaccount());
    }

    @Test
    public void selectByAccount() {

    }
    @Test
    public void insert() {
        Admin admin = new Admin();
        admin.setAdminid("1004");
        admin.setAdminaccount("xiaozhang");
        admin.setAdminname("小张");
        admin.setAdminpassword("xiaozhang");
        Assert.assertEquals(1,adminMapper.insert(admin));
    }
    @Test
    public void delete()
    {
        Assert.assertEquals(1,adminMapper.deleteByPrimaryKey("2345678"));
    }

    @Test
    public void update()
    {
        Admin admin = new Admin();
        admin.setAdminid("1003");
        admin.setAdminaccount("xiaozhang");
        admin.setAdminname("小马");
        admin.setAdminpassword("xiaozhang");
        Assert.assertEquals(1,adminMapper.updateByPrimaryKey(admin));
    }
}
