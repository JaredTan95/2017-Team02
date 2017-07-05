package cn.cqjtu.lexian.service.producation.Impl;

import cn.cqjtu.lexian.common.util.UUidUtils;
import cn.cqjtu.lexian.dao.ProductionExpandMapper;
import cn.cqjtu.lexian.dao.ProductionMapper;
import cn.cqjtu.lexian.model.Production;
import cn.cqjtu.lexian.model.ProductionQuery;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.producation.ProductionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 实现商品服务
 * Created by allen on 2017/7/1.
 */
@Service
@Transactional
public class ProductionServiceImpl implements ProductionService {
    ProductionMapper productionMapper;



    @Autowired
    ProductionExpandMapper productionExpandMapper;

    @Autowired
    public void setProductionMapper(ProductionMapper productionMapper) {
        this.productionMapper = productionMapper;
    }

    @Override
    public Message addOneProduction(Production production) {
        try{
            production.setProid(UUidUtils.uuid().replaceAll("-",""));
            production.setProductionStatusId(1);
            production.setProsalevolume(0);
            return productionMapper.insert(production)>0?
                    Message.getSuccessMessage().put("success","添加成功"):Message.getSuccessMessage().put("error","添加商品参数不合法");
        }catch (Exception e){
            return Message.getFailedMessage().put("message",e.getMessage());
        }
    }

    @Override
    public Message findOneProduction(Production production) {
        try{
            return Message.getSuccessMessage()
                    .put("production", productionMapper.selectByPrimaryKey(production.getProid()));
        }catch (Exception e){
            return Message.getFailedMessage().put("message",e.getMessage());
        }
    }

    @Override
    public Message updateProduction(Production production) {
        try{
            return productionMapper.updateByPrimaryKeySelective(production)>0?
                    Message.getSuccessMessage():Message.getFailedMessage();
        }catch (Exception e){
            return Message.getFailedMessage().put("message",e.getMessage());
        }

    }

    @Override
    public Message findProductionByProductionQuery(ProductionQuery query) {
        try{
            PageHelper.startPage(Integer.parseInt(query.getPn()),12);
            List<Production> list=productionExpandMapper.findProductionByProductionQuery(query);
            System.out.println(list.size()+"------------------");
            PageInfo pageInfo=new PageInfo(list,5);
            return Message.getSuccessMessage().put("pageInfo",pageInfo);
        }
        catch (Exception e){
            e.printStackTrace();
            return Message.getFailedMessage().put("error","服务器忙");
        }

    }

    @Override
    public Message cancleProduction(String productionId) {
        try {
            int i = productionExpandMapper.cancleProduction(productionId);
            if(i<=0){
                return Message.getSuccessMessage().put("error","不存在的商品");
            }else{
                return Message.getSuccessMessage().put("success","商品下架成功");
            }
        }catch (Exception e){
            return Message.getSuccessMessage().put("error","服务器忙~");
        }
    }


}
