package cn.cqjtu.lexian.dao.production;

import cn.cqjtu.lexian.common.util.UUidUtils;
import cn.cqjtu.lexian.dao.ProductionExpandMapper;
import cn.cqjtu.lexian.dao.ProductionMapper;
import cn.cqjtu.lexian.model.Production;
import cn.cqjtu.lexian.model.ProductionQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by allen on 2017/7/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class ProductionDaoTest {
    @Autowired
    ProductionMapper productionMapper;

    @Test
    public void insert(){
        int proBar=1;
        Production production=new Production();
        for(int i=1;i<100;i++){
            production.setProid(UUidUtils.uuid().replaceAll("-",""));
            production.setProbar(proBar+"");
            production.setProductionStatusId(2);
            production.setProname("鲜橙多"+proBar);
            production.setProprice(BigDecimal.TEN);
            production.setProdscp("自动添加数据");
            production.setPromainpic("没图");
            production.setProstorage(999);
            production.setProsalevolume(0);
            productionMapper.insert(production);
            proBar++;
        }
    }


    @Autowired
    private ProductionExpandMapper productionExpandMapper;

    @Test
    public void  queryProduction(){
        ProductionQuery query=new ProductionQuery();
       // query.setProName("多");
        //query.setMinPrice("9");
        //query.setMaxPrice("90");
        //query.setOrderByVolume("2323");
        //query.setCategoryId("49daea18450b4aa7adaa12a7f5464c2f");
        List<Production> list = productionExpandMapper.findProductionByProductionQuery(query);
        for (Production p:list){
            System.out.println(p.getProid()+"==========="+p.getProsalevolume());
        }
        System.out.println(list.size());

    }


}
