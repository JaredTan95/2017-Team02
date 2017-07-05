package cn.cqjtu.lexian.service.producation;

import cn.cqjtu.lexian.model.Production;
import cn.cqjtu.lexian.model.ProductionQuery;
import cn.cqjtu.lexian.model.message.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tanjian on 2017/7/1.
 * 商品服务接口
 */

public interface ProductionService {
    /**
     * Add one production .
     *
     * @param production the production
     * @return the message
     */
    Message addOneProduction(Production production);

    /**
     * Find one production .
     *
     * @param production the production
     * @return the message
     */
    Message findOneProduction(Production production);

    /**
     * Update one production .
     *
     * @param production the production
     * @return the message
     */
    Message updateProduction(Production production);


    /**
     * 根据商品查询条件动态查询
     * @param query
     * @return
     */
    Message findProductionByProductionQuery(ProductionQuery query);


    Message cancleProduction(String productionId);

}
