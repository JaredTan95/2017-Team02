package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.ProductionStatus;
import org.springframework.stereotype.Component;

@Component
public interface ProductionStatusMapper {
    int deleteByPrimaryKey(Integer productionStatusId);

    int insert(ProductionStatus record);

    int insertSelective(ProductionStatus record);

    ProductionStatus selectByPrimaryKey(Integer productionStatusId);

    int updateByPrimaryKeySelective(ProductionStatus record);

    int updateByPrimaryKey(ProductionStatus record);
}