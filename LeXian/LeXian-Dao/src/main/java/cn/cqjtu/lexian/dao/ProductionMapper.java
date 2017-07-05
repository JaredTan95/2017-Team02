package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Production;
import org.springframework.stereotype.Component;

@Component
public interface ProductionMapper {
    int deleteByPrimaryKey(String proid);

    int insert(Production record);

    int insertSelective(Production record);

    Production selectByPrimaryKey(String proid);

    int updateByPrimaryKeySelective(Production record);

    int updateByPrimaryKey(Production record);
}