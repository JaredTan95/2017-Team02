package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.ShopcartProduction;
import org.springframework.stereotype.Component;

@Component
public interface ShopcartProductionMapper {
    int deleteByPrimaryKey(String spId);

    int insert(ShopcartProduction record);

    int insertSelective(ShopcartProduction record);

    ShopcartProduction selectByPrimaryKey(String spId);

    int updateByPrimaryKeySelective(ShopcartProduction record);

    int updateByPrimaryKey(ShopcartProduction record);
}