package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Pro2cateKey;
import org.springframework.stereotype.Component;

@Component
public interface Pro2cateMapper {
    int deleteByPrimaryKey(Pro2cateKey key);

    int insert(Pro2cateKey record);

    int insertSelective(Pro2cateKey record);
}