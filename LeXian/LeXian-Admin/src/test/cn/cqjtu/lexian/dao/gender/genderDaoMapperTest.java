package cn.cqjtu.lexian.dao.gender;

import cn.cqjtu.lexian.dao.GenderMapper;
import cn.cqjtu.lexian.model.Gender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by User on 2017/7/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class genderDaoMapperTest {

    @Autowired
    private GenderMapper genderMapper;

    @Test
    public void insert() {
        Gender gender=new Gender();
        gender.setGenderid(1002);
        gender.setUserid("1004");
        gender.setGenderdesc("女");
        Assert.assertEquals(1,genderMapper.insert(gender));
    }
    @Test
    public void selectByPrimaryKey(){
        Gender gender=new Gender();
        gender=genderMapper.selectByPrimaryKey(1001);
        Assert.assertEquals("男",gender.getGenderdesc());
    }

    @Test
    public void updateByPrimaryKey() {
        Gender gender=new Gender();
        gender.setGenderid(1001);
        gender.setUserid("1003");
        gender.setGenderdesc("女");
        Assert.assertEquals(1,genderMapper.updateByPrimaryKey(gender));
    }

    @Test
    public void deleteByPrimaryKey(){
        Assert.assertEquals(1,genderMapper.deleteByPrimaryKey(1001));
    }

}
