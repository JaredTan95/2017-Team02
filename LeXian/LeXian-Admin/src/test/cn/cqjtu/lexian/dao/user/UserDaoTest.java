package cn.cqjtu.lexian.dao.user;

import cn.cqjtu.lexian.dao.UserMapper;
import cn.cqjtu.lexian.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by allen on 2017/7/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UserDaoTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void Select() {
        Assert.assertEquals("xiaoma",
                userMapper.selectByPrimaryKey("1003").getUseraccount());
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUserid("1005");
        user.setShopcartid("1001");
        user.setUseraccount("xiaozhang");
        user.setUsermail("898783922@qq.com");
        user.setUsername("小张");
        user.setUserpassword("xiaozhang");
        Assert.assertEquals(1, userMapper.insert(user));

    }

    @Test
    public void update() {
        User user = new User();
        user.setUserid("1005");
        user.setShopcartid("1001");
        user.setUseraccount("xiaozhang");
        user.setUsermail("898783922@qq.com");
        user.setUsername("小谭");
        user.setUserpassword("xiaozhang");
    }

    @Test
    public void delete() {
        Assert.assertEquals(1, userMapper.deleteByPrimaryKey("1005"));
    }

    @Test
    public void add() {
        for (int i = 100; i < 200; i++) {
            User user = new User();
            user.setUserid(UUID.randomUUID().toString().replaceAll("-", ""));
            user.setUsername("user" + i);
            user.setUseraccount("user" + i);
            user.setUserpassword("user" + i);
            user.setUsermail("799243917@qq.com");
            userMapper.insert(user);
        }
    }
}
