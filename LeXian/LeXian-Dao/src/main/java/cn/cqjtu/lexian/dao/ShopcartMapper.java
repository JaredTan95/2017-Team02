package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Shopcart;
import org.springframework.stereotype.Component;

@Component
public interface ShopcartMapper {
    int deleteByPrimaryKey(String shopcartid);

    int insert(Shopcart record);

    int insertSelective(Shopcart record);

    Shopcart selectByPrimaryKey(String shopcartid);

    int updateByPrimaryKeySelective(Shopcart record);

    int updateByPrimaryKey(Shopcart record);
}