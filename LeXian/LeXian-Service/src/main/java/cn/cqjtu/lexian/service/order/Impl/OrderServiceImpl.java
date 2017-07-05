package cn.cqjtu.lexian.service.order.Impl;

import cn.cqjtu.lexian.common.util.OutOrderNum;
import cn.cqjtu.lexian.common.util.UUidUtils;
import cn.cqjtu.lexian.dao.*;
import cn.cqjtu.lexian.model.*;
import cn.cqjtu.lexian.model.message.Message;
import cn.cqjtu.lexian.service.order.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by allen on 2017/7/1.
 * 订单
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private OrderExpandMapper orderExpandMapper;
    private UserOrderMapper userOrderMapper;

    @Autowired
    private OrderDetailExpandMapper orderDetailExpandMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    public void setOrderExpandMapper(OrderExpandMapper orderExpandMapper) {
        this.orderExpandMapper = orderExpandMapper;
    }

    @Autowired
    public void setUserOrderMapper(UserOrderMapper userOrderMapper) {
        this.userOrderMapper = userOrderMapper;
    }


    @Autowired
    private ProductionMapper productionMapper;

    @Autowired
    private AddressExpandMapper addressExpandMapper;

    @Autowired
    private  OrderAddressMapper orderAddressMapper;


    /**
     * 解析订单中的商品ID
     * @param json
     * @return
     */
    private Map<String,Integer> getProductionIds4Order(String json){
        Map<String ,Integer> map=null;
        try {
            JSONArray array=new JSONArray(json);
            map=new HashMap<>();
            for (int i=0;i<array.length();i++){
                JSONObject object=array.getJSONObject(i);
                map.put(object.getString("productionId"),object.getInt("amount"));
            }
        }catch (Exception e){
            System.out.println("添加订单的商品信息不合法不合法");
            map=null;
        }
        return map;
    }


    /**
     * 过滤合法的商品信息生成订单详情
     * @return
     */
    private  UserOrder addOrderDeatilByFilter(Map<String ,Integer> map,String userId){
        UserOrder userOrder=null;
        String orderNum=OutOrderNum.OrderNum();
        Float totalPrice=0f;
        Set<String> ids = map.keySet();

        for (int i = 0; i <ids.size() ; i++) {
            String key= (String) ids.toArray()[i];
            Production production=productionMapper.selectByPrimaryKey(key);
            if(production!=null){
                if(userOrder==null){
                    userOrder =new UserOrder();
                    userOrder.setOrderid(orderNum);
                    userOrder.setOrderdatetime(new Date());
                    userOrder.setOrderstatusId(1);//1是未付款
                    userOrder.setUserid(userId);
                }
                OrderDetail orderDetail=new OrderDetail();
                orderDetail.setOrderdetailId(UUidUtils.uuid().replaceAll("-",""));
                orderDetail.setOrderdetailProductionId(production.getProid());
                orderDetail.setOrderid(orderNum);
                Float price=Float.parseFloat(production.getProprice().toString());
                orderDetail.setOrderdetailProductionPrice(price);
                int amount=map.get(key);
                orderDetail.setOrderdetailProductionAmount(amount);
                totalPrice+=price*amount;
                production.setProsalevolume(production.getProsalevolume()+amount);
                orderDetailMapper.insert(orderDetail);
                productionMapper.updateByPrimaryKey(production);
            }
        }
        userOrder.setOrdertotalprice(totalPrice);
        return userOrder;
    }


    /**
     * 为订单生成收货人地址信息
     * @param orderId
     * @param addressId
     * @return
     */
    private Integer addOrderAddress(String orderId,String addressId){
        OrderAddress address=new OrderAddress();
        address.setOrderAddressId(UUidUtils.uuid().replaceAll("-",""));
        address.setOrderId(orderId);
        address.setAddressId(addressId);
        return  orderAddressMapper.addOrderAddress(address);
    }


    @Override
    public Message addOneOrder(OrderExpand userOrder) {
        try {
            Address address;
            if(userOrder.getAddressId()==null){
                return Message.getSuccessMessage().put("error","收货人地址不能为空");
            }else{
                address  = addressExpandMapper.findAddressByAddressId(userOrder.getAddressId());
                if(address==null){
                    return Message.getSuccessMessage().put("error","不存在的收货人");
                }
            }
            Map<String ,Integer> map = getProductionIds4Order(userOrder.getProductionIds());
            if (map == null) {
                return Message.getSuccessMessage().put("error", "订单商品参数不合法");
            }

            UserOrder order=addOrderDeatilByFilter(map,userOrder.getUserid());
            if(order==null){
                return Message.getSuccessMessage().put("error", "订单商品参数不合法");
            }
            int num_o=userOrderMapper.insert(order);
            int num_a=addOrderAddress(order.getOrderid(),address.getAddressid());

            return (num_a>0&&num_o>0)?Message.getSuccessMessage().put("userOrder",order)
                    :Message.getFailedMessage().put("error","订单生成失败!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.getFailedMessage().put("error","服务器忙～"+e.getMessage());
        }
    }

    @Override
    public Message findOneOrder(UserOrder userOrder) {
        try {
            UserOrder order=userOrderMapper.selectByPrimaryKey(userOrder);
            return order!=null?Message.getSuccessMessage().put("userOrder",order)
                    :Message.getSuccessMessage().put("'error'","该订单不存在~");
        }catch (Exception e){
            return Message.getFailedMessage().put("error","服务器忙～"+e.getMessage());
        }
    }

    @Override
    public Message findAllMyOrder(OrderQuery query) {
        PageHelper.startPage(query.getPn(), 10);
        List<OrderShow> list = orderExpandMapper.orderSelective(query);
        PageInfo pageInfo = new PageInfo(list, 5);
        return Message.getSuccessMessage().put("pageInfo", pageInfo);
    }

    @Override
    public Message cancelOneOrder(UserOrder userOrder) {
        return null;
    }

    @Override
    public Message pay4OneOrder(UserOrder userOrder) {
        return null;
    }

    @Override
    public Message orderSelective(OrderQuery query) {
        PageHelper.startPage(query.getPn(), 10);
        List<OrderShow> list = orderExpandMapper.orderSelective(query);
        PageInfo pageInfo = new PageInfo(list, 5);
        return Message.getSuccessMessage().put("pageInfo", pageInfo);
    }

    @Override
    public Message findOrderDetailByOrderId(String orderId) {
        if (orderId==null||orderId.length()<=0){
            return Message.getSuccessMessage().put("error","订单编号不合法");
        }else{
            List<OrderDetail> list = orderDetailExpandMapper.findOrderDetailByOrderId(orderId);
            if(list==null){
                return Message.getSuccessMessage().put("error","不存在的订单编号");
            }else{
                return Message.getSuccessMessage().put("orderDetail",list);
            }
        }
    }

    @Override
    public Message payOrder(String orderId) {
        try{
            int payNum = orderExpandMapper.payOrder(orderId);
            if(payNum<=0){
                return Message.getSuccessMessage().put("error","支付失败，不存在的订单");
            }
            return Message.getSuccessMessage().put("success","支付成功，等待商家发货");
        }catch (Exception e){
            return  Message.getSuccessMessage().put("error","支付失败，请稍后重试");
        }
    }

    @Override
    public Message cancleOrder(String orderId) {
        if(orderId==null||orderId.length()<=0){
            return Message.getSuccessMessage().put("error","不合法的订单编号");
        }else {
            if (orderExpandMapper.cancleOrder(orderId) > 0) {
                return Message.getSuccessMessage().put("success", "取消订单成功");
            } else {
                return Message.getSuccessMessage().put("error", "不合法的订单编号");
            }
        }
    }


}
