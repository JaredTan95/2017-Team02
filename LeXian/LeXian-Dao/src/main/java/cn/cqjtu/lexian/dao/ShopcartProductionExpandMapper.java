package cn.cqjtu.lexian.dao;

import cn.cqjtu.lexian.model.ShopcartProduction;
import cn.cqjtu.lexian.model.ShopcartProductionShow;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShopcartProductionExpandMapper {
   ShopcartProduction findByProductionIdandShopcartId(ShopcartProduction sp);

   int updateByShopcartIdandProductionId(ShopcartProduction sp);


   List<ShopcartProductionShow> queryAll(String userId);




   int deleteShopcartproduction(ShopcartProduction shopcartProduction);

}