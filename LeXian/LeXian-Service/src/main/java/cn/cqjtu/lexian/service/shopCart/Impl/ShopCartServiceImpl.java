package cn.cqjtu.lexian.service.shopCart.Impl;

import cn.cqjtu.lexian.dao.*;
import cn.cqjtu.lexian.model.Shopcart;
import cn.cqjtu.lexian.model.ShopcartProduction;
import cn.cqjtu.lexian.model.ShopcartProductionShow;
import cn.cqjtu.lexian.model.User;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.shopCart.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by allen on 2017/7/1.
 * 购物车接口实现类
 */
@Service
@Transactional
public class ShopCartServiceImpl implements ShopCartService {

    private ShopcartMapper shopcartMapper;
    private ShopcartProductionMapper shopcartProductionMapper;

    private ShopCartExpandMapper shopCartExpandMapper;

    private ProductionMapper productionMapper;



    @Autowired
    public void setShopcartMapper(ShopcartMapper shopcartMapper) {
        this.shopcartMapper = shopcartMapper;
    }

    @Autowired
    public void setShopcartProductionMapper(ShopcartProductionMapper shopcartProductionMapper) {
        this.shopcartProductionMapper = shopcartProductionMapper;
    }

    @Autowired
    public void setShopCartExpandMapper(ShopCartExpandMapper shopCartExpandMapper) {
        this.shopCartExpandMapper = shopCartExpandMapper;
    }

    @Autowired
    public void setProductionMapper(ProductionMapper productionMapper) {
        this.productionMapper = productionMapper;
    }


    @Override
    public Message initShopCart(User user) {
        try {
            Shopcart shopcart = new Shopcart();
            shopcart.setUserid(user.getUserid());
            shopcart.setShopcartid(user.getUserid());
            shopcart.setProductionKindAmount(0);
            return shopcartMapper.insert(shopcart) > 0
                    ? Message.getSuccessMessage().put("shopCart", shopcart)
                    : Message.getSuccessMessage().put("error", "初始化购物车失败～");
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", "初始化购物车失败～");
        }
    }

    @Override
    public Message add2ShopCart(ShopcartProduction sp) {
        try {
            ShopcartProduction find = findShopcartProductionByShopcartIdandProductionId(sp);
            if(find!=null){
                find.setProductionAmount(find.getProductionAmount()+sp.getProductionAmount());
                shopcartProductionExpandMapper.updateByShopcartIdandProductionId(find);
                return Message.getSuccessMessage().put("success","添加成功");
            }
            return shopcartProductionMapper.insert(sp) > 0 ?
                    Message.getSuccessMessage().put("shopcartProduction", sp)
                    : Message.getSuccessMessage().put("error", "你想收藏一件错误的商品迈?");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.getFailedMessage().put("error", "瞎jb操作，信不信封你的号！");
        }
    }

    @Override
    public Message findAllMyShopCart(User user) {
        try {
            return Message.getSuccessMessage().put("shopCartLists", shopCartExpandMapper.findAllMyShopCart(user));
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", "你要搞哪样？嗯～？" + e.getMessage());
        }
    }

    @Override
    public Message findOneMyShopCart(ShopcartProduction sp) {
        try {
            return Message.getSuccessMessage().put("production", productionMapper.selectByPrimaryKey(sp.getProductionId()));
        } catch (Exception e) {
            return Message.getFailedMessage().put("找不到你收藏的商品了~", e.getMessage());
        }
    }

    @Override
    public Message delOneMyShopCart(ShopcartProduction sp) {
        try {
            return shopcartProductionMapper.deleteByPrimaryKey(sp.getSpId()) > 0
                    ? Message.getSuccessMessage() : Message.getSuccessMessage().put("error", "删除失败了～");
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", "搞不来你要的删除～");
        }
    }

    @Override
    public Message delAllMyShopCart(ShopcartProduction sp) {
        /*DELETE  FROM shopcart_production WHERE shopcartId =?  */
        try {
            return shopCartExpandMapper.delAllMyShopCart(sp) > 0
                    ? Message.getSuccessMessage() : Message.getSuccessMessage().put("error", "清空购物车失败～");
        } catch (Exception e) {
            return Message.getFailedMessage().put("error", "清空购物车失败～");
        }
    }



    @Autowired
    private ShopcartProductionExpandMapper shopcartProductionExpandMapper;
    @Override
    public Message updateAmount(ShopcartProduction shopcartProduction) {
        try {
            int i = shopcartProductionExpandMapper.updateByShopcartIdandProductionId(shopcartProduction);
            if(i<=0){
                return Message.getSuccessMessage().put("error","操作不合法");
            }
            return Message.getSuccessMessage().put("success","修改成功");
        }catch (Exception e){
            return Message.getSuccessMessage().put("error","服务器忙~");
        }
    }

    @Override
    public Message queryAll(String userId) {
        try {
            List<ShopcartProductionShow> shopcartProductions = shopcartProductionExpandMapper.queryAll(userId);
            return Message.getSuccessMessage().put("shopcartProductions",shopcartProductions);
        }catch (Exception e){
            return Message.getSuccessMessage().put("error","服务器忙~");
        }
    }

    @Override
    public Message cancleProductionByProductionId(ShopcartProduction shopcartProduction) {
        if(shopcartProduction.getProductionId()==null||shopcartProduction.getShopcartid()==null){
            return Message.getSuccessMessage().put("error","参数不合法");
        }
        try {
            int i = shopcartProductionExpandMapper.deleteShopcartproduction(shopcartProduction);
            if(i<=0){
                return Message.getSuccessMessage().put("error","参数不合法");
            }else{
                return Message.getSuccessMessage().put("success","从购物车中删除商品成功");
            }
        }catch (Exception e){
            return Message.getSuccessMessage().put("error","服务器忙~");
        }
    }


    public ShopcartProduction findShopcartProductionByShopcartIdandProductionId(ShopcartProduction shopcartProduction){
       return  shopcartProductionExpandMapper.findByProductionIdandShopcartId(shopcartProduction);
    }

}
