package cn.cqjtu.lexian.model;

/**
 * Created by zjhfyq on 2017/7/3.
 */
public class OrderAddress {

    private String orderAddressId;
    private String orderId;
    private String addressId;

    public String getOrderAddressId() {
        return orderAddressId;
    }

    public void setOrderAddressId(String orderAddressId) {
        this.orderAddressId = orderAddressId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
