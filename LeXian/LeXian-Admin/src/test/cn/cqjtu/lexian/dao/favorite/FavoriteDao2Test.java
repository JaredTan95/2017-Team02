package cn.cqjtu.lexian.dao.favorite;

import cn.cqjtu.lexian.dao.AddressMapper;
import cn.cqjtu.lexian.dao.FavoriteMapper;
import cn.cqjtu.lexian.model.Address;
import cn.cqjtu.lexian.model.AddressKey;
import cn.cqjtu.lexian.model.Favorite;
import cn.cqjtu.lexian.model.FavoriteKey;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/*
 * 项目名称：LeXian
 * 类描述：
 * 创建人：xiaoma
 * 创建时间：2017/7/1 15:51
 * 修改人：xiaoma
 * 修改时间：2017/7/1 15:51
 * 修改备注：import java.util.Date;
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public  class FavoriteDao2Test {
    @Autowired
    private FavoriteMapper favoriteMapper;


    @Test
    public void insert() {
        Favorite favorite= new Favorite();
        favorite.setUserid("1003");
        favorite.setProid("1001");
        favorite.setFavoriteid("1001");
        favorite.setFavoritedate(new Date(2017-1900,7-1,1));
        Assert.assertEquals(1, favoriteMapper.insert(favorite));
    }

    @Test
    public void delete()
    {
        Favorite favorite= new Favorite();
        favorite.setUserid("1003");
        favorite.setProid("1001");
        favorite.setFavoriteid("1001");
        Assert.assertEquals(1, favoriteMapper.deleteByPrimaryKey(favorite));
    }

    @Test
    public void update()
    {
        Favorite favorite= new Favorite();
        favorite.setUserid("1003");
        favorite.setProid("1001");
        favorite.setFavoriteid("1001");
        favorite.setFavoritedate(new Date(2014-1900,6-1,1));
        Assert.assertEquals(1,favoriteMapper.updateByPrimaryKey(favorite));
    }
    @Test
    public void select() {
        Favorite favorite= new Favorite();
        favorite.setUserid("1003");
        favorite.setProid("1001");
        favorite.setFavoriteid("1001");
        Assert.assertEquals(new Date(2017-1900,7-1,1), favoriteMapper.selectByPrimaryKey(favorite).getFavoritedate());
    }



}
