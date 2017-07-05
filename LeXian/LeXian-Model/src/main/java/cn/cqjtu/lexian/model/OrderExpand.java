package cn.cqjtu.lexian.model;

/**
 * Created by zjhfyq on 2017/7/2.
 */
public class OrderExpand extends  UserOrder {
    /**
     * 用于保存订单中的商品ID，可以有多个，需要切割
     */
    private String productionIds;

    public String getProductionIds() {
        return productionIds;
    }

    public void setProductionIds(String productionIds) {
        this.productionIds = productionIds;
    }

    /**
     * 收货人ID
     */
    private  String addressId;


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
