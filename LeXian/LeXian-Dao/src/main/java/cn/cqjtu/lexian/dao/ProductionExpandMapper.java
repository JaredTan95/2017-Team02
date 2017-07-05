package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.Production;
import cn.cqjtu.lexian.model.ProductionQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductionExpandMapper {
    List<Production> findProductionByProductionQuery(ProductionQuery query);


    int cancleProduction(String productionId);
}