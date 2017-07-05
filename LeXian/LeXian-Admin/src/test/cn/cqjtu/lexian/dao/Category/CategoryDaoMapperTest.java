package cn.cqjtu.lexian.dao.Category;

import cn.cqjtu.lexian.dao.CategoryMapper;
import cn.cqjtu.lexian.model.Category;
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
public class CategoryDaoMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void insert(){
        Category category=new Category();
        category.setCategoryid("1003");
        category.setCategorytitle("食品");
        Assert.assertEquals(1,categoryMapper.insert(category));
    }
    @Test
    public void selectByPrimaryKey(){
        Category category=new Category();
        category=categoryMapper.selectByPrimaryKey("1001");
        Assert.assertEquals("服装",category.getCategorytitle());
    }
    @Test
    public void updateByPrimaryKey(){
        Category category=new Category();
        category.setCategoryid("1001");
        category.setCategorytitle("水果");
        Assert.assertEquals(1,categoryMapper.updateByPrimaryKey(category));
    }

    @Test
    public void deleteByPrimaryKey(){
        Assert.assertEquals(1,categoryMapper.deleteByPrimaryKey("1002"));

    }
}
